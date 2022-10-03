import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {
    private List<MovieDesc> movieDescList;
    private List<Movie> movieList;
    private Bill bill=null;

    public VODService(int port) throws RemoteException {
        super(port);
        movieDescList=new ArrayList<>();
        movieList=new ArrayList<>();
        MovieDesc movieDesc1=new MovieDesc("Robocop1","0","Insane film1");
        MovieDesc movieDesc2=new MovieDescExtended("Robocop2","1","Insane film2", new byte[][]{("blabiblo").getBytes(StandardCharsets.UTF_8), ("dazoazdoi").getBytes(StandardCharsets.UTF_8)});
        MovieDesc movieDesc3=new MovieDesc("Robocop3","2","Insane film3");

        Movie movie1=new Movie(movieDesc1, new byte[][]{("blabla").getBytes(StandardCharsets.UTF_8),("bliblo").getBytes(StandardCharsets.UTF_8),("bldzandazon").getBytes(StandardCharsets.UTF_8)},1000);
        Movie movie2=new Movie(movieDesc2, new byte[][]{("siuuu").getBytes(StandardCharsets.UTF_8),("uuuuuuu").getBytes(StandardCharsets.UTF_8),("bldazdzadzandazon").getBytes(StandardCharsets.UTF_8)},2000);
        Movie movie3=new Movie(movieDesc3, new byte[][]{("oooooo").getBytes(StandardCharsets.UTF_8),("yyyyyy").getBytes(StandardCharsets.UTF_8),("bldzandazdazon").getBytes(StandardCharsets.UTF_8)},3000);

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

    public void filmrun(Movie movieCurrent,IClientBox box) throws RemoteException, InterruptedException {
        box.setMovieIsPlaying(true);
        for (byte[] tab: movieCurrent.moviebytes){
            Thread.sleep(1000);
            box.stream(tab);
            System.out.println(Arrays.toString(tab));
        }
        box.setMovieIsPlaying(false);
    }

    public Bill playmovie(String isbn, IClientBox box) throws Exception {
        Movie moviecurrent=null;
        for (Movie movie: movieList){
            if (movie.getMovieIspn().equals(isbn)){
                moviecurrent=movie;
            }
        }
        if (moviecurrent==null){
            throw new Exception();
        }
        Movie finalMoviecurrent = moviecurrent;
        Thread t = new Thread() {
            public void run() {
                try {
                    filmrun(finalMoviecurrent,box);
                } catch (RemoteException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        return new Bill(finalMoviecurrent.getMovieName(),finalMoviecurrent.price);

    }
}
