package com.graphqljava.tutorial.bookDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Book(String id, String name, int pageCount, String authorId) {

    private static List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")
    ));

    public static List<Book> getAll() {
        return books;
    }

    public static Book getById(String id) {
        return books.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id().equals(updatedBook.id())) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    public static Boolean deleteBook(String id) {
        return books.removeIf(book -> book.id().equals(id));
    }

}