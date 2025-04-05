package com.graphqljava.tutorial.bookDetails.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Khóa chính
    private String name;
    private int pageCount;
    private Long authorId;  // Liên kết tới Author (Foreign Key)

    // Constructors, Getters, and Setters

    public Book() { }

    public Book(String name, int pageCount, Long authorId) {
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
