package com.example.authors;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable("id") long id) {
        return service.getAuthor(id);
    }

    @GetMapping()
    public List<AuthorDto> getAuthor() {
        return service.listAllAuthor();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthor(@RequestBody CreateAuthorCommand command) {
        return service.saveAuthor(command);
    }

    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto addBookToAuthor(@PathVariable("id") long id, @RequestBody CreateBookCommand command) {
        return service.addBookToAuthor(id, command);
    }

    @DeleteMapping("/{id}")
    public void removeAuthor(@PathVariable("id") long id) {
        service.removeAuthor(id);
    }
}
