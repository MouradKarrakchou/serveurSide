import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Connection {
    ArrayList<Client> clientList;
    //throws SignInFailed

    public Connection(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    boolean signIn (String mail, String pwd){

    }
    //(eg, if a client with this email already exists)
    //throws InvalidCredentialsException
    IVODService login(String mail, String pwd){
        Client loginClient = new Client(mail, pwd);
        for(Client client: clientList){
            if(client.equals(loginClient)){
                System.out.println("Login successful");
                return new IVODService;
            }
        }
        throws InvalidCredentialsException;
    }
    //(if mail/pwd don't match)
}
