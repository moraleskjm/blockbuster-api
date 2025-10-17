package com.morales.blockbuster.service;

import com.morales.blockbuster.dto.MovieDto;
import com.morales.blockbuster.models.Movie;
import com.morales.blockbuster.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepo movieRepo;

    public MovieDto createMovie(MovieDto movieDto) {

        //Create Movie
        Movie movie = new Movie();

        //Constructor
        movie.setTitle(movieDto.title());
        movie.setReleaseYear(movieDto.releaseYear());
        movie.setGenre(movieDto.movieGenre());
        movie.setFormat(movieDto.movieFormat());
        movie.setStock(movieDto.stock());
        movie.setUpc(movieDto.upc());
        movie.setDailyPrice(movieDto.dailyPrice());

        //Save movie to DB
        Movie savedMovie = movieRepo.save(movie);

        return new MovieDto(
                savedMovie.getTitle(),
                savedMovie.getReleaseYear(),
                savedMovie.getGenre(),
                savedMovie.getFormat(),
                savedMovie.getStock(),
                savedMovie.getUpc(),
                savedMovie.getDailyPrice()
        );
    }

    //Get Movies (Used Stream instead and sorted by movie titles Alphabetically)
    public List<MovieDto> getAllMovies() {
        return movieRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER))
                .map(movie -> new MovieDto(
                        movie.getTitle(),
                        movie.getReleaseYear(),
                        movie.getGenre(),
                        movie.getFormat(),
                        movie.getStock(),
                        movie.getUpc(),
                        movie.getDailyPrice()
                ))
                .toList();
    }

    //Find movie by ID
    public MovieDto getMovieById(Integer id) {
        //Find Movie by ID -> Throw error if Movie ID not found
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No movie found with ID:" + id));

        //Convert to DTO and return (RESEARCH SERVICE HELPER AND USE IT!!)
        return new MovieDto(
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getGenre(),
                movie.getFormat(),
                movie.getStock(),
                movie.getUpc(),
                movie.getDailyPrice()
        );
    }

    //Update movie (R)
    public MovieDto updateMovie(Integer id, MovieDto movieDto) {
        //Find movie by ID -> Throw error if not found
        Movie movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No movie found with ID: " + id));

        //Update fields
        movie.setTitle(movieDto.title());
        movie.setReleaseYear(movieDto.releaseYear());
        movie.setGenre(movieDto.movieGenre());
        movie.setFormat(movieDto.movieFormat());
        movie.setStock(movieDto.stock());
        movie.setUpc(movieDto.upc());
        movie.setDailyPrice(movieDto.dailyPrice());

        //Save updated movie
        Movie updatedMovie = movieRepo.save(movie);

        return new MovieDto(
                updatedMovie.getTitle(),
                updatedMovie.getReleaseYear(),
                updatedMovie.getGenre(),
                updatedMovie.getFormat(),
                updatedMovie.getStock(),
                updatedMovie.getUpc(),
                updatedMovie.getDailyPrice()
        );
    }

    //Find movie by name (R)
    public List<MovieDto> searchMovieByTitle(String title) {
        return movieRepo.findByTitleContainingIgnoreCase(title)
                .stream()
                .sorted(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER))
                .map(movie -> new MovieDto(
                        movie.getTitle(),
                        movie.getReleaseYear(),
                        movie.getGenre(),
                        movie.getFormat(),
                        movie.getStock(),
                        movie.getUpc(),
                        movie.getDailyPrice()
                ))
                .toList();
    }

    //Delete movie
    public String deleteMovie(Integer id) {
        //Check if movie exists
        if (!movieRepo.existsById(id)) {
            throw new RuntimeException("No movie found with ID: " + id);
        }
        movieRepo.deleteById(id);
        return "Deleted movie with ID: " + id;
    }
}
