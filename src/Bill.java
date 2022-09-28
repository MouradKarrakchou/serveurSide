import java.math.BigInteger;

public class Bill implements IBill{
    String movieName;
    BigInteger outrageousPrice;


    public Bill(String movieName, BigInteger outrageousPrice) {
        this.movieName = movieName;
        this.outrageousPrice = outrageousPrice;
    }
}
