import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Registry reg= LocateRegistry.createRegistry(2001);
        ObjetDistant d = new ObjetDistant(10001);
        reg.rebind("MonOD",d);
    }
}
