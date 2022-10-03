import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Connection extends UnicastRemoteObject implements IConnection {
    ArrayList<Client> clientList;
    VODService vodService = new VODService(1000);

    CsvManager csvManager = new CsvManager("clientList.csv");


    public Connection(int numport) throws RemoteException {
        super(numport);
        try {
            System.out.println(csvManager.getClientList());
            this.clientList = csvManager.getClientList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean signIn(String mail, String pwd) throws SignInFailed {
        Client loginClient = new Client(mail, pwd);
        for (Client client : clientList) {
            if (client.equals(loginClient)) {
                throw new SignInFailed();
            }
        }
        try {
            csvManager.addClient(loginClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clientList.add(loginClient);
        return true;
    }

    public IVODService login(String mail, String pwd) throws InvalidCredentialsException {
        Client loginClient = new Client(mail, pwd);
        for (Client client : clientList) {
            System.out.println(client);
            if (client.equals(loginClient)) {
                System.out.println("Login successful");
                return vodService;
            }
        }
        throw new InvalidCredentialsException();
    }
}
