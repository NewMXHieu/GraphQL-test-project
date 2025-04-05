package com.graphqljava.tutorial.bookDetails.repository;

import com.graphqljava.tutorial.bookDetails.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
