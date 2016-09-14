package stelo.subacquirer.sdk;

import java.io.IOException;
import java.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import stelo.subacquirer.sdk.request.SteloError;
import stelo.subacquirer.sdk.request.SteloException;

public class Subacquirer {
	private SteloAccount steloAccount;
	private Environment environment;

	/**
	 * Create a Subacquirer instance defining the stelo account and the
	 * environment
	 * 
	 * @param steloAccount
	 * @param environment
	 */
	public Subacquirer(SteloAccount steloAccount, Environment environment) {
		this.steloAccount = steloAccount;
		this.environment = environment;
	}

	/**
	 * Create a Subacquirer instance defining the stelo account
	 * 
	 * @param steloAccount
	 */
	public Subacquirer(SteloAccount steloAccount) {
		this(steloAccount, Environment.PRODUCTION);
	}

	/**
	 * After the customer make the purchase steps of the store, choose Stelo
	 * payment method and click in “Checkout”, the store will carry out the
	 * request by sending the data
	 * 
	 * @param transaction
	 * @return
	 * @throws IOException
	 * @throws SteloException
	 */
	public Transaction createTransaction(Transaction transaction) throws IOException, SteloException {
		String url = environment.getUrl() + "/ec/V1/subacquirer/transactions/";

		String entity = new GsonBuilder().disableHtmlEscaping().create().toJson(transaction);

		RequestBody body = RequestBody.create(MediaType.parse("application/json"), entity);

		String response = sendRequest(new Request.Builder().url(url).post(body));
		Gson gson = new Gson();

		return gson.fromJson(response, Transaction.class);
	}

	/**
	 * After the customer make the purchase steps of the store, choose Stelo
	 * payment method and click in “Checkout”, the store will carry out the
	 * request by sending the data
	 * 
	 * @param order
	 * @param payment
	 * @param customer
	 * @return
	 * @throws IOException
	 * @throws SteloException
	 */
	public Transaction createTransaction(Order order, Payment payment, Customer customer)
			throws IOException, SteloException {

		return createTransaction(new Transaction(order, payment, customer));
	}

	/**
	 * After creating a transaction and the buyer give up the purchase, Stelo
	 * allows to cancel the request. To do this simply send a REQUEST informing
	 * the orderId.
	 * 
	 * @param orderId
	 * @throws IOException
	 * @throws SteloException
	 */
	public void cancellTransaction(String orderId) throws IOException, SteloException {
		String url = environment.getUrl() + "/ec/V1/orders/transactions/" + orderId;

		sendRequest(new Request.Builder().url(url).delete());
	}

	/**
	 * Upon receiving query the status of a transaction, Stelo will return the
	 * statusCode and statusMessage parameters.
	 * 
	 * @param orderId
	 * @return The requested Order
	 * @throws IOException
	 * @throws SteloException
	 */
	public Order getTransaction(String orderId) throws IOException, SteloException {
		String url = environment.getUrl() + "/ec/V1/orders/transactions/" + orderId;

		String response = sendRequest(new Request.Builder().url(url).get());
		Gson gson = new Gson();

		return gson.fromJson(response, Order.class);
	}

	String sendRequest(Builder requestBuilder) throws IOException, SteloException {
		String credentials = steloAccount.getClientId() + ":" + steloAccount.getClientSecret();
		String encoded = Base64.getEncoder().encodeToString(credentials.getBytes());

		OkHttpClient client = new OkHttpClient();

		requestBuilder.addHeader("Accept", "application/json");
		requestBuilder.addHeader("Content-Type", "application/json");
		requestBuilder.addHeader("User-Agent", "Subacquirer-SDK/1.0");
		requestBuilder.addHeader("Authorization", "Basic " + encoded);

		Response response = client.newCall(requestBuilder.build()).execute();

		return readResponse(response);
	}

	String readResponse(Response response) throws IOException, SteloException {
		String responseBody = response.body().string();
		int statusCode = response.code();

		System.out.println(responseBody);
		System.out.println(statusCode);

		if (!response.isSuccessful()) {
			if (statusCode >= 400 && statusCode < 500) {
				SteloException exception = null;

				switch (statusCode) {
				case 403:
					exception = new SteloException("Access Denied", new SteloError(403, "Access Denied", ""),
							exception);

					break;
				case 404:
					exception = new SteloException("Not found", new SteloError(404, "Not found", ""), exception);

					break;

				default:
					SteloError error;

					try {
						error = new Gson().fromJson(responseBody, SteloError.class);

					} catch (JsonSyntaxException e) {
						// TODO: string|array strategy

						error = new SteloError(statusCode, "");
					}

					exception = new SteloException(error.getMessage(), error, exception);
				}

				throw exception;
			} else if (statusCode >= 500) {
				throw new SteloException("Internal Server Error");
			}
		}

		return responseBody;
	}
}
