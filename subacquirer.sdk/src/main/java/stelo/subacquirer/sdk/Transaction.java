package stelo.subacquirer.sdk;

public class Transaction {
	private Order orderData;
	private Payment paymentData;
	private Customer customerData;
	private String bankSlipURL;

	public String getBankSlipURL() {
		return bankSlipURL;
	}

	public Transaction(Order orderData, Payment paymentData, Customer customerData) {
		this.orderData = orderData;
		this.paymentData = paymentData;
		this.customerData = customerData;
	}

	public Order getOrderData() {
		return orderData;
	}

	public Payment getPaymentData() {
		return paymentData;
	}

	public Customer getCustomerData() {
		return customerData;
	}

	public Transaction setOrderData(Order orderData) {
		this.orderData = orderData;

		return this;
	}

	public Transaction setPaymentData(Payment paymentData) {
		this.paymentData = paymentData;

		return this;
	}

	public Transaction setCustomerData(Customer customerData) {
		this.customerData = customerData;

		return this;
	}
}
