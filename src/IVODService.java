import java.util.List;

public interface IVODService {
    List<MovieDesc> viewCatalog();
    IBill playmovie(String isbn, IClientBox box);
}
