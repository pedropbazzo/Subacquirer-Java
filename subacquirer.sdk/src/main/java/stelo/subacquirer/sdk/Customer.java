package stelo.subacquirer.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Customer {
	public enum Gender {
		F, M
	}

	@SerializedName("customerIdentity")
	private String identity;

	@SerializedName("customerName")
	private String name;

	@SerializedName("customerEmail")
	private String email;

	private String birthDate;

	private Address billingAddress;

	private Address shippingAddress;

	@SerializedName("phoneData")
	private List<Phone> phones;

	private Gender gender;

	public Customer() {
		this.phones = new ArrayList<Phone>();
	}

	public Customer addPhone(Phone phone) {
		phones.add(phone);

		return this;
	}

	public Customer addNewPhone(String areaCode, String number, Phone.Type type) {
		return addPhone(new Phone(areaCode, number, type));
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public Gender getGender() {
		return gender;
	}

	public String getIdentity() {
		return identity;
	}

	public String getName() {
		return name;
	}

	public Iterator<Phone> getPhoneIterator() {
		return phones.iterator();
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Customer setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;

		return this;
	}

	public Customer setBirthDate(String birthDate) {
		this.birthDate = birthDate;

		return this;
	}

	public Customer setEmail(String email) {
		this.email = email;

		return this;
	}

	public Customer setGender(Gender gender) {
		this.gender = gender;

		return this;
	}

	public Customer setIdentity(String identity) {
		this.identity = identity;

		return this;
	}

	public Customer setName(String name) {
		this.name = name;

		return this;
	}

	public Customer setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;

		return this;
	}
}