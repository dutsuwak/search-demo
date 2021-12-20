package com.search.demo.frameworks;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.search.demo.controller.Movie;

/**
 * Interface that allows the support of multiple
 * search engines and frameworks.
 *
 * This is the common interface for frameworks family.
 */
public class CSVSearchFramework implements iSearchFramework {

    private List<Movie> movies;

    @Override
    public void setup(String searchArg){
        movies = new ArrayList<Movie>();

        String filename = System.getProperty("user.dir") + "/" + searchArg;

        try {
            FileReader filereader = new FileReader(filename);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext(); //Skip first line
            while ((nextRecord = csvReader.readNext()) != null) {

                List<String> mv = new ArrayList<String>();
                for (String cell : nextRecord) {
                    mv.add(cell);
                }

                Movie newMovie = new Movie(mv.get(0), mv.get(1), mv.get(2), mv.get(3),
                                           mv.get(4), mv.get(5), mv.get(6), mv.get(7),
                                           mv.get(8), mv.get(9), mv.get(10), mv.get(11),
                                           mv.get(12), mv.get(13));
                movies.add(newMovie);
            }

            csvReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };

    @Override
    public Movie searchByTitle(String title){
        Movie retMovie = new Movie();

        for(Movie movie : this.movies){
            if(movie.getName().equals(title)){
                return movie;
            }
        }

        /* Exact movie title was not found suggest one */
        for(Movie movie : this.movies){
            if(movie.getName().contains(title)){
                return movie;
            }
        }

        retMovie.setName("Not found.");

        return retMovie;
    };

    @Override
    public List<Movie> searchByRate(int low, int high, String genre){
        List<Movie> mlist = new ArrayList<Movie>();

        for(Movie movie : this.movies){
            float movieRate = 0;
            if(!movie.getRate().contains("No Rate")){
                movieRate = Float.parseFloat(movie.getRate());
            }
            if(movieRate >= low && movieRate < high){
                if(!genre.equals("none")){
                    if(movie.getGenre().contains(genre)){
                        mlist.add(movie);
                    }
                }
                else{
                    mlist.add(movie);
                }
            }
        }

        return mlist;
    };

    @Override
    public List<Movie> searchByGenre(String genre){
        List<Movie> mlist = new ArrayList<Movie>();

        for(Movie movie : this.movies){
            if(movie.getGenre().contains(genre)){
                mlist.add(movie);
            }
        }

        return mlist;
    };
}
