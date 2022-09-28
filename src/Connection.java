import java.lang.reflect.Array;

public class Connection {
    Array clientList;
    //throws SignInFailed
    boolean signIn (String mail, String pwd){return true;}
    //(eg, if a client with this email already exists)
    //throws InvalidCredentialsException
    IVODService login(String mail, String pwd){return null;}
    //(if mail/pwd don't match)
}
