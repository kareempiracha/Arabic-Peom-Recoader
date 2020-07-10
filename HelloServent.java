package application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServent extends UnicastRemoteObject implements HelloService {

	protected HelloServent() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String echo(String input, int type) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(input + type);
		return input;
	}

}
