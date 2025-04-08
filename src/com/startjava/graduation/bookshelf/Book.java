package com.startjava.graduation.bookshelf;

public class Book {

    private final String authorName;
    private final String title;
    private final String publicationYear;

    public Book(String[] bookAttributes) {
        authorName = bookAttributes[0];
        title = bookAttributes[1];
        publicationYear = bookAttributes[2];
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return authorName + ", " + title + ", " + publicationYear;
    }
}
