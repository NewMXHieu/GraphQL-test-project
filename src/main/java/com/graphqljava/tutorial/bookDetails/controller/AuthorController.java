package com.graphqljava.tutorial.bookDetails.controller;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public Author authorById(@Argument Long id) {
        return authorService.getAuthorById(id).orElse(null);
    }

    @QueryMapping
    public List<Author> authors() {
        return authorService.getAllAuthors();
    }

    @MutationMapping
    public Author addAuthor(@Argument String firstName, @Argument String lastName) {
        Author author = new Author(firstName, lastName);
        return authorService.addAuthor(author);
    }

    @MutationMapping
    public Author updateAuthor(@Argument Long id, @Argument String firstName, @Argument String lastName) {
        Author author = authorService.getAuthorById(id).orElse(null);
        if (author != null) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            return authorService.updateAuthor(author);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteAuthor(@Argument Long id) {
        return authorService.deleteAuthor(id);
    }
}
