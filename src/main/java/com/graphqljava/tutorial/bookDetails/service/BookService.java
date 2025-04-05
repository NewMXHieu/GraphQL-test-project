package com.graphqljava.tutorial.bookDetails.service;

import com.graphqljava.tutorial.bookDetails.model.Book;
import com.graphqljava.tutorial.bookDetails.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> searchBooksByName(String name) {
        return bookRepository.findByNameContaining(name);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Boolean deleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
