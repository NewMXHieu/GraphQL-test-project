package com.graphqljava.tutorial.bookDetails.repository;

import com.graphqljava.tutorial.bookDetails.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContaining(String name);
    List<Book> findByAuthorId(Long authorId);
}
