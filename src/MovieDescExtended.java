import java.util.Arrays;

public class MovieDescExtended extends MovieDesc implements IMovieDesc {
    Byte[] teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis, Byte[] teaser) {
        super(movieName, isbn, synopsis);
        this.teaser=teaser;
    }

    @Override
    public String toPrint() {
        return
                "movieName='" + movieName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", teaser=" + Arrays.toString(teaser);
    }
}
