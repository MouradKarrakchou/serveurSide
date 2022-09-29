import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {
    private List<MovieDesc> movieDescList;
    private List<Movie> movieList;

    public VODService(int port) throws RemoteException {
        super(port);
        movieDescList=new ArrayList<>();
        movieList=new ArrayList<>();
        MovieDesc movieDesc1=new MovieDesc("Robocop1","02032039","Insane film1");
        MovieDesc movieDesc2=new MovieDesc("Robocop2","0321031","Insane film2");
        MovieDesc movieDesc3=new MovieDesc("Robocop3","43941293","Insane film3");

        Movie movie1=new Movie(movieDesc1,("blabla").getBytes(StandardCharsets.UTF_8),1000);
        Movie movie2=new Movie(movieDesc2,("blabla").getBytes(StandardCharsets.UTF_8),2000);
        Movie movie3=new Movie(movieDesc3,("blabla").getBytes(StandardCharsets.UTF_8),3000);

        movieDescList.add(movieDesc1);
        movieDescList.add(movieDesc2);
        movieDescList.add(movieDesc3);

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

    }

    public List<MovieDesc> viewCatalog(){
        return(movieDescList);
    }

    public Bill playmovie(String isbn, IClientBox box) throws RemoteException {
        for (Movie movie: movieList){
            if (movie.getMovieIspn().equals(isbn)){
                box.stream(movie.moviebytes);
                return new Bill(movie.getMovieName(),movie.price);
            }
        }
        return null;
    }
}
