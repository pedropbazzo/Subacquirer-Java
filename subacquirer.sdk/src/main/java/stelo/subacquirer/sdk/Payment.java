package stelo.subacquirer.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Payment {
	public enum PaymentType {
		@SerializedName("credit")
		CREDIT, @SerializedName("bankSlip")
		BANK_SLIP
	}

	public class Card {
		private final String token;

		public Card(String cardToken) {
			this.token = cardToken;
		}

		public String getCardToken() {
			return token;
		}
	}

	private PaymentType paymentType;
	private Double amount;
	private Double freight;
	@SerializedName("cartData")
	private List<Product> cart;
	private String currency;

	@SerializedName("cardData")
	private Card card;
	private Integer installment;

	private Double discountAmount;

	public Payment() {
		cart = new ArrayList<Product>();
	}

	public Payment addNewProduct(String name, Double price, Integer quantity, String sku) {
		Product product = new Product(name, price, quantity);

		product.setSku(sku);

		return addProduct(product);
	}

	public Payment addNewProduct(String name, Double price, Integer quantity) {
		return addProduct(new Product(name, price, quantity));
	}

	public Payment addNewProduct(String name, Double price) {
		return addNewProduct(name, price, 1);
	}

	public Payment addProduct(Product product) {
		cart.add(product);

		return this;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public Double getAmount() {
		return amount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public Double getFreight() {
		return freight;
	}

	public String getCurrency() {
		return currency;
	}

	public Card getCard() {
		return card;
	}

	public Integer getInstallment() {
		return installment;
	}

	public Iterator<Product> getCartIterator() {
		return cart.iterator();
	}

	public Payment setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;

		return this;
	}

	public Payment setAmount(Double amount) {
		this.amount = amount;

		return this;
	}

	public Payment setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;

		return this;
	}

	public Payment setFreight(Double freight) {
		this.freight = freight;

		return this;
	}

	public Payment setCurrency(String currency) {
		this.currency = currency;

		return this;
	}

	public Payment setCard(String token) {
		this.card = new Card(token);

		setPaymentType(PaymentType.CREDIT);

		return this;
	}

	public Payment setInstallment(Integer installment) {
		this.installment = installment;

		return this;
	}
}
