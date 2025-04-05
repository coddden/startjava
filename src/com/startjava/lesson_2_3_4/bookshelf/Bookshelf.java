package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int SHELF_LEN = 40;
    public static final int SHELF_COUNT = 10;
    private final Book[] books = new Book[SHELF_COUNT];
    private int bookCount = 0;

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    public int getBookCount() {
        return bookCount;
    }

    public int countEmptyShelves() {
        return books.length - bookCount;
    }

    public boolean add(Book book) {
        if (bookCount >= SHELF_COUNT) {
            throw new ArrayIndexOutOfBoundsException("\nВ шкафу закончилось место! " +
                    "Книга не может быть сохранена.");
        }
        if (book.toString().length() > SHELF_LEN) {
            throw new IllegalArgumentException("\nКнига не помещается на полку!");
        }
        books[bookCount++] = book;
        return true;
    }

    public Book find(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                return books[i];
            }
        }
        return null;
    }

    public boolean delete(String title) {
        Book book = find(title);
        if (book == null) return false;
        for (int i = 0; i < bookCount; i++) {
            if (book.equals(books[i])) {
                bookCount--;
                if (i != bookCount) {
                    System.arraycopy(books, i + 1, books, i, bookCount - i);
                }
                books[bookCount] = null;
                break;
            }
        }
        return true;
    }

    public void clearBookshelf() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
    }
}
