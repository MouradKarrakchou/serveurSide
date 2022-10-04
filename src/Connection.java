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

    /**
     * Register a client
     * @param mail
     * @param pwd
     * @return true if the client is correctly register, otherwise false
     * @throws SignInFailed, when the client try to register with a mail already know
     */
    public boolean signIn(String mail, String pwd) throws SignInFailed {
        Client loginClient = new Client(mail, pwd);
        for (Client client : clientList) {
            if (client.sameEmail(loginClient)) {
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

    /**
     * Login the client into the Vod service
     * @param mail
     * @param pwd
     * @return IVODService, that the client will use to interact with the systeme
     * @throws InvalidCredentialsException, when the client try to login with wrong mail and password
     */
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
