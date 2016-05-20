import java.io.Serializable;
import java.util.ArrayList;

public class RequestBody implements Serializable{
private Coordinate parameters = new Coordinate();
private ClientProxy clientproxy = new ClientProxy();
private String servicename = new String();

public RequestBody(Coordinate parameters) {
	super();
	this.parameters = parameters;
}

public RequestBody(ClientProxy client){
	super();
	this.clientproxy = client;
}

public RequestBody(ClientProxy client, String servname){
	super();
	this.clientproxy = client;
	this.servicename = servname;
}


public ClientProxy getClientproxy() {
	return clientproxy;
}

public void setClientproxy(ClientProxy clientproxy) {
	this.clientproxy = clientproxy;
}

public String getServicename() {
	return servicename;
}

public void setServicename(String servicename) {
	this.servicename = servicename;
}

public Coordinate getParameters() {
	return parameters;
}

public void setParameters(Coordinate parameters) {
	this.parameters = parameters;
}

}
