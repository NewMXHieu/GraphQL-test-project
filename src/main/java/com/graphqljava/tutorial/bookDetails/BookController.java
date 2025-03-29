package com.graphqljava.tutorial.bookDetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> books() {
        return Book.getAll();
    }

    @MutationMapping
    public Book addBook(@Argument String name, @Argument int pageCount, @Argument String authorId) {
        Book newBook = new Book("book-" + (Book.getAll().size() + 1), name, pageCount, authorId);
        Book.addBook(newBook);
        return newBook;
    }

    @MutationMapping
    public Book updateBook(@Argument String id, @Argument String name, @Argument int pageCount, @Argument String authorId) {
        Book book = Book.getById(id);
        if (book != null) {
            book = new Book(id, name, pageCount, authorId);
            Book.updateBook(book);
            return book;
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteBook(@Argument String id) {
        Book book = Book.getById(id);
        if (book != null) {
            boolean bookDeleted = Book.deleteBook(id);
            if (bookDeleted) {
                Author.deleteAuthorById(book.authorId());
            }
            return bookDeleted;
        }
        return false;
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

}