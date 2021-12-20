package com.search.demo.frameworks;

import java.util.List;

import com.search.demo.controller.Movie;

/**
 * Interface that allows the support of multiple
 * search engines and frameworks.
 *
 * This is the common interface for frameworks family.
 */
public interface iSearchFramework {

    /**
     * Initializes the framework based on the required search configuration
     * 
     * @param searchArg indicates initialization argument for each framework
     */
    void setup(String searchArg);

    /**
     * Indexes information by the name of the movie
     * 
     * @param title search argument
     */
    Movie searchByTitle(String title);

    /**
     * Indexes information by the rate of the movie based on
     * the low and high rate filters as [low, high[
     * 
     * @param low lower range including this value
     * @param high higher range excluding this value
     */
    List<Movie> searchByRate(int low, int high, String genre);

    /**
     * Provides the information by the matching genre of the movie
     * 
     * @param genre string to search for a maching value
     */
    List<Movie> searchByGenre(String genre);
}
