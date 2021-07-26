package com.example.movie;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable("id") long id) {
        return service.getMovie(id);
    }

    @GetMapping()
    public List<MovieDto> getMovie() {
        return service.listAllMovie();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody CreateMovieCommand command) {
        return service.saveMovie(command);
    }

    @PostMapping("/{id}/rating")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto addRating(@PathVariable("id") long id, @RequestBody AddRatingCommand command) {
        return service.addRating(id, command);
    }
}
