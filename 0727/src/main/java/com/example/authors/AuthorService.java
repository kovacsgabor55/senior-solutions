package com.example.authors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {

    private final ModelMapper modelMapper;

    private final AuthorRepository repository;

    public AuthorDto getAuthor(long id) {
        return modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Author not fount: " + id)),
                AuthorDto.class);
    }

    public List<AuthorDto> listAllAuthor() {
        return repository.findAll().stream().map(a -> modelMapper.map(a, AuthorDto.class))
                .collect(Collectors.toList());
    }

    public AuthorDto saveAuthor(CreateAuthorCommand command) {
        Author author = new Author(command.getName());
        repository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Transactional
    public AuthorDto addBookToAuthor(long id, CreateBookCommand command) {
        Author author = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found: " + id));
        Book book = new Book(command.getIsbn(), command.getTitle());
        author.addBook(book);
        return modelMapper.map(author, AuthorDto.class);
    }

    public void removeAuthor(long id) {
        repository.deleteById(id);
    }
}
