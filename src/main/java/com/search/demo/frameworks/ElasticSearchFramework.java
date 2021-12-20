package com.search.demo.frameworks;

import java.util.ArrayList;
import java.util.List;
import com.search.demo.controller.Movie;

/**
 * Interface that allows the support of multiple
 * search engines and frameworks.
 *
 * This is the common interface for frameworks family.
 */
public class ElasticSearchFramework implements iSearchFramework {

    private List<Movie> movies;

    @Override
    public void setup(String searchArg){
        /* Not implemented yet */
    };

    @Override
    public Movie searchByTitle(String title){
        Movie movie = new Movie();
        
        /* Not implemented yet */

        return movie;
    };

    @Override
    public List<Movie> searchByRate(int low, int high, String genre){
        List<Movie> mlist = new ArrayList<Movie>();

        /* Not implemented yet */

        return mlist;
    };

    @Override
    public List<Movie> searchByGenre(String genre){
        List<Movie> mlist = new ArrayList<Movie>();

        /* Not implemented yet */
        return mlist;
    };
}
