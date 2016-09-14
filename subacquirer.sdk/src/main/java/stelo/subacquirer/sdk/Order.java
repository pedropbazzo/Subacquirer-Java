package stelo.subacquirer.sdk;

import com.google.gson.annotations.SerializedName;

public class Order {
	public enum ShippingBehavior {
		/**
		 * Delivery time in average time (2 to 10 working days)
		 */
		@SerializedName("default")
		DEFAULT,

		/**
		 * Digital product
		 */
		@SerializedName("digital")
		DIGITAL,

		/**
		 * Delivery time up to 12 hours after payment approval
		 */
		@SerializedName("express")
		EXPRESS,

		/**
		 * Delivery time above 10 days
		 */
		@SerializedName("extensive")
		EXTENSIVE,
		/**
		 * Time deliveries done between 12 hours and 2 working days after
		 * approval
		 */
		@SerializedName("fast")
		FAST,

		/**
		 * Service
		 */
		@SerializedName("service")
		SERVICE,

		/**
		 * Product will be taken in store
		 */
		@SerializedName("storePickup")
		STORE_PICKUP
	}

	class Status {
		private String statusCode;
		private String statusMessage;

		public Status() {
		}

		public String getStatusCode() {
			return statusCode;
		}

		public String getStatusMessage() {
			return statusMessage;
		}
	}

	private Double amount;
	private String autorizationId;
	private Double freight;
	private Integer installment;
	private Integer nsu;
	private String orderId;
	private String secureCode;
	private ShippingBehavior shippingBehavior = ShippingBehavior.DEFAULT;
	private String steloId;
	private Status steloStatus;
	private String tid;

	public Order() {
	}

	public Order(String orderId) {
		this(orderId, ShippingBehavior.DEFAULT);
	}

	public Order(String orderId, ShippingBehavior shippingBehavior) {
		this.orderId = orderId;
		this.shippingBehavior = shippingBehavior;
	}

	public Double getAmount() {
		return amount;
	}

	public String getAutorizationId() {
		return autorizationId;
	}

	public Double getFreight() {
		return freight;
	}

	public Integer getInstallment() {
		return installment;
	}

	public Integer getNsu() {
		return nsu;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getSecureCode() {
		return secureCode;
	}

	public ShippingBehavior getShippingBehavior() {
		return shippingBehavior;
	}

	public String getSteloId() {
		return steloId;
	}

	public Status getSteloStatus() {
		return steloStatus;
	}

	public String getTid() {
		return tid;
	}

	public void setNsu(Integer nsu) {
		this.nsu = nsu;
	}

	public Order setOrderId(String orderId) {
		this.orderId = orderId;

		return this;
	}

	public Order setSecureCode(String secureCode) {
		this.secureCode = secureCode;

		return this;
	}

	public Order setShippingBehavior(ShippingBehavior shippingBehavior) {
		this.shippingBehavior = shippingBehavior;

		return this;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
}