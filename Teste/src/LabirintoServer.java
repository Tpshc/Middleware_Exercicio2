import java.io.IOException;

public class LabirintoServer {

	public LabirintoServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, Throwable{
		
		Invoker invoker = new Invoker();
		AppProxy proxy = new AppProxy();
		//NamingProxy namingService = new NamingProxy("localhost", 60000);
		proxy.setHost("localhost");
		proxy.setPort(60004);
		System.out.println("começou servidor");
		invoker.invoke(proxy);
		System.out.println("tgerminou servidor");


	}

}
