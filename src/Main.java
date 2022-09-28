import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Registry reg= LocateRegistry.createRegistry(2001);
        Connection conection = new Connection(10001,null);
        reg.rebind("MonOD",conection);
    }
}
