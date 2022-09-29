package exception;

import java.rmi.RemoteException;

public class SignInFailed extends Exception {
    public SignInFailed() {
        super("Erreur de lors de l'inscription, un compte avec le même email existe déjà");
    }
}
