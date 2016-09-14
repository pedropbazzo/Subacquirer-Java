package stelo.subacquirer.sdk;

public enum Environment {
	PRODUCTION("https://api.stelo.com.br"),
	// SANDBOX("http://localhost");
	SANDBOX("https://apic1.hml.stelo.com.br");

	private String url;

	Environment(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
