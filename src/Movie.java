public class Movie {
    MovieDesc movieDesc;
    byte[] moviebytes;
    int price;
    public Movie(MovieDesc movieDesc,byte[] moviebytes,int price){
        this.movieDesc=movieDesc;
        this.moviebytes=moviebytes;
        this.price=price;
    }
    public String getMovieIspn(){
        return(movieDesc.isbn);
    }
    public String getMovieName(){
        return(movieDesc.movieName);
    }
}