package stelo.subacquirer.sdk;

public class Address {
	public String street;
	public String number;
	public String neighborhood;
	public String zipCode;
	public String city;
	public String state;
	public String country;
	public String complement;

	public Address() {
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getComplement() {
		return complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getNumber() {
		return number;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipCode;
	}

	public Address setCity(String city) {
		this.city = city;

		return this;
	}

	public Address setComplement(String complement) {
		this.complement = complement;

		return this;
	}

	public Address setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;

		return this;
	}

	public Address setNumber(String number) {
		this.number = number;

		return this;
	}

	public Address setStreet(String street) {
		this.street = street;

		return this;
	}

	public Address setZipcode(String zipcode) {
		this.zipCode = zipcode;

		return this;
	}

	public Address setState(String state) {
		this.state = state;

		return this;
	}

	public Address setCountry(String country) {
		this.country = country;

		return this;
	}

}