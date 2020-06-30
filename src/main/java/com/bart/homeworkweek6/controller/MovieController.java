package com.bart.homeworkweek6.controller;

import com.bart.homeworkweek6.model.Movie;
import com.bart.homeworkweek6.service.MovieService;
import com.bart.homeworkweek6.service.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {

        model.addAttribute("list", movieService.getMovieList());
        model.addAttribute("newMovie", new Movie());

        return "index";
    }

    @SendEmail
    @PostMapping("/add")
    public String addMovie(Movie movie) {
        movieService.getMovieList().add(movie);

        return "redirect:/";
    }
}
