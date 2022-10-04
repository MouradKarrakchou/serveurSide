import java.util.Objects;

public class Client {
    String mail;
    String pwd;

    public Client(String mail, String pwd) {
        this.mail = mail;
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean sameEmail(Object o){
        if(o instanceof Client){
            Client other = (Client) o;
            return other.getMail().equals(this.mail);
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Client){
            Client other = (Client) o;
            return other.getMail().equals(this.mail) && other.getPwd().equals(this.pwd);
        }
        return false;
    }
}
