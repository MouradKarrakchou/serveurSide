import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException, SignInFailed, InvalidCredentialsException {
        Registry reg= LocateRegistry.createRegistry(2001);
        Connection connection = new Connection(10001);
        reg.rebind("MonOD",connection);


    }
}
