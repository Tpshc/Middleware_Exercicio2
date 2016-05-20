import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NamingProxy extends ClientProxy implements INaming {
		
		private static final long serialVersionUID = 1L;
		public NamingProxy(){}
			
		
		public char bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, IOException,Throwable{
			
			return 'k';
		}
		
		public ClientProxy looup(String serviceName) throws UnknownHostException, IOException,Throwable{
			
		}
		
		public ArrayList<String> list() throws UnknownHostException, IOException,Throwable{
			
		}
		
		@Override
		public char canIMove (Coordinate coord)throws Throwable{
			
			Invocation inv = new Invocation();
			Termination ter = new Termination();
			String methodName = null;
			class Local{};
		//	Requestor requestor = new Requestor();
			
			methodName = Local.class.getEnclosingMethod().getName();	
			
			inv.setId(this.getObjectId());
			inv.setPort(this.getPort());
			inv.setAddress(this.getHost());
			inv.setOperationName(methodName);
			inv.setParameters(coord);
			
			//ter = requestor.invoke(inv);
			
			return (Character) ter.getResposta();
		}
	}


