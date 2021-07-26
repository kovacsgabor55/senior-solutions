package com.example.movie;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final ModelMapper modelMapper;

    private final MovieRepository repository;

    public MovieDto getMovie(long id) {
        return modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Movie not fount: " + id)),
                MovieDto.class);
    }

    public List<MovieDto> listAllMovie() {
        return repository.findAll().stream().map(m -> modelMapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }

    public MovieDto saveMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle());
        repository.save(movie);
        return modelMapper.map(movie, MovieDto.class);
    }

    @Transactional
    public MovieDto addRating(long id, CreateRatingCommand command) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found: " + id));
        movie.addRatings(command.getRating());
        return modelMapper.map(movie, MovieDto.class);
    }
}
