import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRequestHandler {
	private String host;
	private int port;
	private int tam_msg_enviada;
	private int tam_msg_recebida;
	
	private Socket clientSocket= null;
	private DataOutputStream outToServer= null;
	private DataInputStream inFromServer= null;
	public ClientRequestHandler(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	public void send(byte[] msg) throws IOException, InterruptedException{
		
		if(clientSocket == null){
			clientSocket = new Socket(this.host, this.port);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new DataInputStream(clientSocket.getInputStream());
		}
		
		tam_msg_enviada = msg.length;
		outToServer.writeInt(tam_msg_enviada);
		outToServer.write(msg, 0, tam_msg_enviada);
		outToServer.flush();
	}
	
	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException{
		byte[] msg = null;
		tam_msg_recebida = inFromServer.readInt();
		msg = new byte[tam_msg_recebida];
		inFromServer.read(msg, 0, tam_msg_recebida);
		
		/*clientSocket.close();
		outToServer.close();
		inFromServer.close();*/
		
		return msg;
	}
	
	public void close() throws IOException{
		clientSocket.close();
		outToServer.close();
		inFromServer.close();
		clientSocket = null;
	}
}
