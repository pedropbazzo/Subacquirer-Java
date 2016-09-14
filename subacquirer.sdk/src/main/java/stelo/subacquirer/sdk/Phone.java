package stelo.subacquirer.sdk;

public class Phone {
	public enum Type {
		CELL, LANDLINE
	}

	private String areaCode;
	private String number;
	private Type type;

	public Phone(String areaCode, String number, Type type) {
		this.areaCode = areaCode;
		this.number = number;
		this.type = type;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getNumber() {
		return number;
	}

	public Type getType() {
		return type;
	}

	public Phone setAreaCode(String areaCode) {
		this.areaCode = areaCode;

		return this;
	}

	public Phone setNumber(String number) {
		this.number = number;

		return this;
	}

	public Phone setType(Type type) {
		this.type = type;

		return this;
	}
}