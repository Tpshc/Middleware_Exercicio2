import java.io.IOException;
import java.rmi.UnknownHostException;

public class Requestor {

	public Termination invoke(Invocation inv) throws UnknownHostException, IOException, Throwable{
		ClientRequestHandler crh = new ClientRequestHandler(inv.getAddress(), inv.getPort());
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination();
		byte [] msgMarshalled;
		byte [] msgToBeUnmarshalled;
		Message msgUnmarshalled = new Message();
		
		RequestHeader requestHeader = new RequestHeader("", 0, true, 0, inv.getOperationName());
		RequestBody requestBody = new RequestBody(inv.getParameters());
		MessageHeader messageHeader = new MessageHeader("MIOP", 0, false, 0, 0);
		MessageBody messageBody = new MessageBody(requestHeader, requestBody, null, null);
		Message msgToBeMarshalled = new Message(messageHeader, messageBody);
		
		msgMarshalled = marshaller.marshall(msgToBeMarshalled);
		
		try {
			crh.send(msgMarshalled);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("erro no send cliente");
		}
		
		msgToBeUnmarshalled = crh.receive();
		
		msgUnmarshalled = marshaller.unmarshall(msgToBeUnmarshalled);
		
	
			try {
				termination.setResposta(msgUnmarshalled.getBody().getReplyBody().getOperationResult());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.sleep(1000);
			}
		
		//crh.close();
		return termination;
	}

}
