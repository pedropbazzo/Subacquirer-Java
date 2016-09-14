package stelo.subacquirer.sdk.request;

public class SteloException extends Exception {
	private static final long serialVersionUID = 5781840084682359474L;
	private SteloError steloError;

	public SteloException() {
	}

	public SteloException(String message) {
		super(message);
	}

	public SteloException(String message, SteloError steloError) {
		this(message);

		this.steloError = steloError;
	}

	public SteloException(String message, SteloError steloError, Throwable cause) {
		super(message, cause);

		this.steloError = steloError;
	}

	public SteloError getSteloError() {
		return steloError;
	}
}