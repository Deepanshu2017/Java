package server;
import java.rmi.*;
import java.rmi.server.*;

/**
 * Created by deepanshu on 1/3/16.
 */
public class ServiceClass extends UnicastRemoteObject implements ServiceInterface {

    public ServiceClass() throws RemoteException {
        super();
    }

    @Override
    public void print(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public int sum(int x, int y) throws RemoteException {
        return x + y;
    }
}