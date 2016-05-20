import java.io.IOException;
import java.net.UnknownHostException;
 

 
public class Invoker {
 
    public void invoke(ClientProxy clientProxy) throws IOException, Throwable {
        ServerRequestHandler srh = new ServerRequestHandler(clientProxy.getPort());
       
        byte[] msgToBeUnmarshalled = null;
 
        byte[] msgMarshalled = null;
       
        Message msgUnmarshalled = new Message();
        
        LabirintoImpl rObj = new LabirintoImpl();
        
        Marshaller marshaller = new Marshaller();
        
        Termination ter = new Termination();
       
       
        while(true){
           msgToBeUnmarshalled = srh.receive();
           
           msgUnmarshalled = marshaller.unmarshall(msgToBeUnmarshalled);
             	   
           ter.setResposta(rObj.canIMove(msgUnmarshalled.getBody().getRequestBody().getParameters()));
           
           Message resposta = new Message(new MessageHeader("protocolo", 0, false, 0, 0), new MessageBody(null, null, new ReplyHeader("", 0, 0), new ReplyBody(ter.getResposta())));
           
           msgMarshalled = marshaller.marshall(resposta);
           
           srh.send(msgMarshalled);
           //srh.close();
           }
 
   
   
}
    
}