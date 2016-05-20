import java.io.Serializable;

public class RequestHeader implements Serializable {

	private String context;
	private int requestId;
	private boolean responseExpected;
	private int objectKey;
	private String operation;
	
	public RequestHeader(String context, int requestId, boolean responseExpected, int objectKey, String operation) {
		super();
		this.context = context;
		this.requestId = requestId;
		this.responseExpected = responseExpected;
		this.objectKey = objectKey;
		this.operation = operation;
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
