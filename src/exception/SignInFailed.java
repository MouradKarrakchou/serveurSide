package exception;

import java.rmi.RemoteException;
/**
 * Trigger when the client try to create a new account with an existing email
 */
public class SignInFailed extends Exception {
    public SignInFailed() {
        super("Erreur lors de l'inscription, un compte avec le même email existe déjà");
    }
}
