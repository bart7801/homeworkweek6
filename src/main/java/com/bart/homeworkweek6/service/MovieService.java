package com.bart.homeworkweek6.service;

import com.bart.homeworkweek6.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public MovieService() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Planet Earth II", 2016, "BBC"));
        movieList.add(new Movie("Dances with Wolves", 1989, "Tig Productions, Majestic Films "));
        movieList.add(new Movie("Pirates of the Caribbean: At World’s End", 2007, "Walt Disney Pictures"));
        movieList.add(new Movie("Avatar", 2009, "20th Century FoxC"));
    }
}
