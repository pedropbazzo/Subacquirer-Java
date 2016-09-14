package stelo.subacquirer.sdk;

import com.google.gson.annotations.SerializedName;

public class Product {
	@SerializedName("productName")
	private String name;
	@SerializedName("productPrice")
	private Double price;
	@SerializedName("productQuantity")
	private int quantity;
	@SerializedName("productSku")
	private String sku;

	public Product(String name, Double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getSku() {
		return sku;
	}

	public Product setName(String name) {
		this.name = name;

		return this;
	}

	public Product setPrice(Double price) {
		this.price = price;

		return this;
	}

	public Product setQuantity(int quantity) {
		this.quantity = quantity;

		return this;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
}
