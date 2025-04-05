package com.graphqljava.tutorial.bookDetails.controller;

import com.graphqljava.tutorial.bookDetails.model.Book;
import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.service.BookService;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookService.getBookById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public List<Book> searchBooksByName(@Argument String name) {
        return bookService.searchBooksByName(name);
    }

    @MutationMapping
    public Book addBook(@Argument String name, @Argument int pageCount, @Argument Long authorId) {
        Author author = authorService.getAuthorById(authorId).orElse(null);
        if (author != null) {
            return bookService.addBook(new Book(name, pageCount, authorId));
        }
        return null;
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument String name, @Argument int pageCount, @Argument Long authorId) {
        Book book = bookService.getBookById(id).orElse(null);
        if (book != null) {
            Author author = authorService.getAuthorById(authorId).orElse(null);
            if (author != null) {
                book.setName(name);
                book.setPageCount(pageCount);
                book.setAuthorId(authorId);
                return bookService.updateBook(book);
            }
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }

    @QueryMapping
    public List<Author> searchAuthorsByName(@Argument String name) {
        return authorService.getAuthorsByName(name);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getAuthorById(book.getAuthorId()).orElse(null);
    }
}
