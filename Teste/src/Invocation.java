import java.util.ArrayList;

public class Invocation {
	int id;
	String address;
	int port;
	String operationName;
	Coordinate parameters;
	
	public Invocation(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public Coordinate getParameters() {
		return parameters;
	}

	public void setParameters(Coordinate parameters) {
		this.parameters = parameters;
	}
	
	
	
}
