package server;
import java.net.*;
import java.rmi.*;

/**
 * Created by deepanshu on 1/3/16.
 */
public class Main {
    public static void main(String args[]) {
        try {
            ServiceClass sc = new ServiceClass();
            Naming.bind("rmi://127.0.0.1:1009/obj", sc);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}