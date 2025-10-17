package com.morales.blockbuster.controllers;

import com.morales.blockbuster.dto.MovieDto;
import com.morales.blockbuster.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    //Health checkpoint
    @GetMapping("/health")
    public String getHealth() {
        return "You are online! 😁";
    }

    @GetMapping("/movies/search") //(R)
    public List<MovieDto> searchMovie(@RequestParam String title) {
        return movieService.searchMovieByTitle(title);
    }

    @PostMapping("/createmovie")
    public MovieDto createMovie(@RequestBody MovieDto movieDto) {
        return movieService.createMovie(movieDto);
    }

    @GetMapping("/movies")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public MovieDto getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/movies/{id}") //(R)
    public MovieDto updateMovie(@PathVariable Integer id, @RequestBody MovieDto movieDto) {
        return movieService.updateMovie(id, movieDto);
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        return movieService.deleteMovie(id);
    }
}
