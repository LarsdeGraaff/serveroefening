package be.vdab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
public class MovieRepository {


    List<Movie> findAllMovies(){
        List<Movie> l=new ArrayList<>();
        l.add(new Movie(1,"Scarface", "al pacino ", 1990));
        l.add(new Movie(2,"American gangster","Denzel Washington",2008));
        l.add(new Movie(3,"Inception","Leonardo Dicaprio", 2010));
        return l;
    }

}
