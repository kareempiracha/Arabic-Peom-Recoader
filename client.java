package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {
	static String results;
	public static void client_caller(String input, int type) throws RemoteException, MalformedURLException, NotBoundException
	{
		HelloService service= (HelloService) Naming.lookup("rmi://localhost:5099/hello");
		results = service.echo(input, type);
		
	}


}
