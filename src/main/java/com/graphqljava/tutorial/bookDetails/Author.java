package com.graphqljava.tutorial.bookDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Author(String id, String firstName, String lastName) {

    private static List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author("author-1", "Joanne", "Rowling"),
            new Author("author-2", "Herman", "Melville"),
            new Author("author-3", "Anne", "Rice")
    ));

    public static Author getById(String id) {
        return authors.stream().filter(author -> author.id().equals(id)).findFirst().orElse(null);
    }

    // Thêm Author mới
    public static void addAuthor(Author author) {
        authors.add(author);
    }

    // Cập nhật Author
    public static void updateAuthor(Author updatedAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).id().equals(updatedAuthor.id())) {
                authors.set(i, updatedAuthor);
                return;
            }
        }
    }

    public static Boolean deleteAuthorById(String id) {
        return authors.removeIf(author -> author.id().equals(id));
    }

    public static Boolean deleteAuthor(String id) {
        return authors.removeIf(author -> author.id().equals(id));
    }

}