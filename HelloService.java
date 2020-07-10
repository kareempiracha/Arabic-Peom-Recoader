package application;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote{

	public String echo(String input, int type) throws RemoteException;

}
