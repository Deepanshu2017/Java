package client;

import server.ServiceInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by deepanshu on 1/3/16.
 */
public class Main {
    public static void main(String args[]) {
        try {
            ServiceInterface sc = (ServiceInterface)Naming.lookup("obj");
            sc.print("Deepanshu");
            System.out.println(sc.sum(5, 7));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}