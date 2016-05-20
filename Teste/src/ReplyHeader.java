import java.io.Serializable;

public class ReplyHeader implements Serializable{
	private String serviceContext;
	private int requestId;
	private int replyStatus;
	public ReplyHeader(String serviceContext, int requestId, int replyStatus) {
		super();
		this.serviceContext = serviceContext;
		this.requestId = requestId;
		this.replyStatus = replyStatus;
	}

}
