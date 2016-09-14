package stelo.subacquirer.sdk;

public class SteloAccount {
	private String clientId;
	private String clientSecret;

	public SteloAccount(String id, String secret) {
		this.clientId = id;
		this.clientSecret = secret;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}
}
