package com.graphqljava.tutorial.bookDetails.service;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByFirstNameContainingOrLastNameContaining(name, name);
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Boolean deleteAuthor(Long id) {
        try {
            authorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
