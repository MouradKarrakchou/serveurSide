import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {
    private List<IMovieDesc> movieList;

    public VODService(int port) throws RemoteException {
        super(port);
        movieList=new ArrayList<>();
        movieList.add(new MovieDesc("Robocop1","02032039","Insane film1"));
        movieList.add(new MovieDesc("Robocop2","0321031","Insane film2"));
        movieList.add(new MovieDesc("Robocop3","43941293","Insane film3"));
    }

    public List<IMovieDesc> viewCatalog(){
        return(movieList);
    }

    public Bill playmovie(String isbn, IClientBox box){
        return null;
    }
}
