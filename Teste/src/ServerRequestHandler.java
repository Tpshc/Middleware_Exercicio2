import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler {

	private int portNumber;
	private ServerSocket welcomeSocket = null;
	private Socket connectionSocket = null;

	private int tam_msg_enviada;
	private int tam_msg_recebida;
	private DataOutputStream outToClient = null;
	private DataInputStream inFromClient = null;

	public ServerRequestHandler(int portNumber) throws IOException {
		super();
		this.portNumber = portNumber;
		welcomeSocket = new ServerSocket(portNumber);
	}

	public void send(byte[] msg) throws IOException, InterruptedException{

		tam_msg_enviada = msg.length;
		outToClient.writeInt(tam_msg_enviada);
		outToClient.write(msg);
		outToClient.flush();
		
		/*connectionSocket.close();
		welcomeSocket.close();
		outToClient.close();
		inFromClient.close();*/

	}

	public byte[] receive() throws IOException, Throwable{

		byte [] rcvMsg = null;	
		
		connectionSocket = welcomeSocket.accept();
		outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		inFromClient = new DataInputStream(connectionSocket.getInputStream());
		tam_msg_recebida = inFromClient.readInt();
		rcvMsg = new byte[tam_msg_recebida];
		
		inFromClient.read(rcvMsg, 0, tam_msg_recebida);

		return rcvMsg;
}
	
	public void close() throws IOException{
		connectionSocket.close();
		welcomeSocket.close();
		outToClient.close();
		inFromClient.close();
		//connectionSocket = null;
	}

}
