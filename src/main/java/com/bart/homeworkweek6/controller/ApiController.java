package com.bart.homeworkweek6.controller;

import com.bart.homeworkweek6.model.Movie;
import com.bart.homeworkweek6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieListApi")
public class ApiController {

    private final MovieService movieService;

    @Autowired
    public ApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieList() {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }
}
