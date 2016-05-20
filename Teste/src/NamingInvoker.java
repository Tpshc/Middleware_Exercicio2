import java.io.IOException;
import java.net.UnknownHostException;

public class NamingInvoker {
	
	 
	    public NamingInvoker(ClientProxy clientProxy) throws IOException, Throwable {
	        NamingServer ns = new NamingServer(clientProxy.getPort());
	       
	        byte[] msgToBeUnmarshalled = null;
	 
	        byte[] msgMarshalled = null;
	       
	        Message msgUnmarshalled = new Message();
	        
	        NamingProxy np = new NamingProxy();
	        
	        Marshaller marshaller = new Marshaller();
	        
	        Termination ter = new Termination();
	       
	       
	        while(true){
	           msgToBeUnmarshalled = ns.receive();
	           
	           msgUnmarshalled = marshaller.unmarshall(msgToBeUnmarshalled);
	             	   
	           switch(msgUnmarshalled.getBody().getRequestHeader().getOperation()){
	           case "bind":
	        	   ter.setResposta(np.bind(msgUnmarshalled.getBody().getRequestBody().getServicename(), msgUnmarshalled.getBody().getRequestBody().getClientproxy()));
	        	   break;
	           case "lookup":
	        	   ter.setResposta(np.lookup(msgUnmarshalled.getBody().getRequestBody().getServicename()));
	        	   break;
	           case "list":
	        	   ter.setResposta(np.list());
	        	   break;
	        	   
	           }
	           
	           Message resposta = new Message(new MessageHeader("protocolo", 0, false, 0, 0), new MessageBody(null, null, new ReplyHeader("", 0, 0), new ReplyBody(ter.getResposta())));
	           
	           msgMarshalled = marshaller.marshall(resposta);
	           
	           ns.send(msgMarshalled);
	           //srh.close();
	           }
	 
	   
	   
	
	    
	}
}
