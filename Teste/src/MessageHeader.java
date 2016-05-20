import java.io.Serializable;

public class MessageHeader implements Serializable{
	private String magic;
	private int version;
	private boolean byteOrder;
	private int messageType;
	private long messageSize;
	
	
	public MessageHeader(String magic, int version, boolean byteOrder, int messageType, long messageSize) {
		super();
		this.magic = magic;
		this.version = version;
		this.byteOrder = byteOrder;
		this.messageType = messageType;
		this.messageSize = messageSize;
	}
}