import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Connection extends UnicastRemoteObject {
    ArrayList<Client> clientList;
    //

    public Connection(int numport,ArrayList<Client> clientList) throws RemoteException {
        super(numport);
        this.clientList = clientList;
    }

    boolean signIn (String mail, String pwd) throws SignInFailed{
        Client loginClient = new Client(mail, pwd);
        for(Client client: clientList){
            if(client.equals(loginClient)){
                System.out.println("Email already exist");
                return false;
            }
        }
        clientList.add(new Client(mail, pwd));
        return true;
    }
    //
    IVODService login(String mail, String pwd) throws InvalidCredentialsException{
        Client loginClient = new Client(mail, pwd);
        try{
            for(Client client: clientList){
                if(client.equals(loginClient)){
                    System.out.println("Login successful");
                    return null;
                }
            }
            throw new Exception();
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    //(if mail/pwd don't match)
}
