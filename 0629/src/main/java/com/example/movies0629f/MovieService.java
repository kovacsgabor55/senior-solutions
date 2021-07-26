package com.example.movies0629f;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MovieService {

    private final ModelMapper modelMapper;
    private final AtomicLong idGenerator = new AtomicLong();
    private final List<Movie> movies = new ArrayList<>();

    public MovieService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<MovieDto> getAllMovies() {
        Type targetListType = new TypeToken<List<MovieDto>>() {
        }.getType();
        return modelMapper.map(movies, targetListType);
    }

    public MovieDto getMovieById(long id) {
        Movie movie = findById(id);
        return modelMapper.map(movie, MovieDto.class);
    }

    public MovieDto createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(idGenerator.incrementAndGet(), command.getTitle(), command.getLength());
        movies.add(movie);
        return modelMapper.map(movie, MovieDto.class);
    }

    public MovieDto addRating(long id, NewMovieRatingCommand command) {
        Movie movie = findById(id);
        movie.addRating(command.getRating());
        return modelMapper.map(movie, MovieDto.class);
    }

    public void deleteMovie(long id) {
        Movie movie = findById(id);
        movies.remove(movie);
    }

    private Movie findById(long id) {
        return movies.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException("Movie not found: " + id));
    }
}
