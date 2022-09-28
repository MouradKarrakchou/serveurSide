import exception.InvalidCredentialsException;
import exception.SignInFailed;

import java.lang.reflect.Array;

public class Connection {
    Array clientList;
    boolean signIn (String mail, String pwd) throws SignInFailed {return true;}
    //(eg, if a client with this email already exists)
    IVODService login(String mail, String pwd) throws InvalidCredentialsException {return null;}
    //(if mail/pwd don't match)
}
