import java.util.ArrayList;

public class AppProxy extends ClientProxy implements IApp {
	
	private static final long serialVersionUID = 1L;
	public AppProxy(){}
	public AppProxy(Coordinate coord){}
	
	@Override
	public char canIMove (Coordinate coord)throws Throwable{
		
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		String methodName = null;
		class Local{};
		Requestor requestor = new Requestor();
		
		methodName = Local.class.getEnclosingMethod().getName();	
		
		inv.setId(this.getObjectId());
		inv.setPort(this.getPort());
		inv.setAddress(this.getHost());
		inv.setOperationName(methodName);
		inv.setParameters(coord);
		
		ter = requestor.invoke(inv);
		
		return (Character) ter.getResposta();
	}
}
