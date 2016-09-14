package stelo.subacquirer.sdk.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * An error containing the attribute and their mistakes.
 */
public class SteloError {
	/**
	 * Error Details
	 */
	public class Detail {
		private List<String> message;

		public Detail() {
			message = new ArrayList<String>();
		}

		public Detail(String message) {
			this();

			this.message.add(message);
		}

		public Iterator<String> getMessageIterator() {
			return message.iterator();
		}
	}

	/**
	 * {@link SteloError#getCode()}
	 */
	@SerializedName("errorCode")
	private int code;

	/**
	 * {@link SteloError#getMessage()}
	 */
	@SerializedName("errorMessage")
	private String message;

	private Detail detail;

	public SteloError() {
	}

	public SteloError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public SteloError(int code, String message, String detail) {
		this.code = code;
		this.message = message;
		this.detail = new Detail(detail);
	}

	/**
	 * @return The error code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return a descriptive error message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return an iterator of error details
	 */
	public Iterator<String> getDetailIterator() {
		return detail.getMessageIterator();
	}
}