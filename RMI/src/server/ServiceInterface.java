package server;
import java.rmi.*;

/**
 * Created by deepanshu on 1/3/16.
 */
public interface ServiceInterface extends Remote {
    public void print(String msg) throws RemoteException;
    public int sum(int a, int b) throws RemoteException;
}