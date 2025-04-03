package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bookshelf {

    public static final int SHELF_LENGTH = 40;
    public static final int SHELF_COUNT = 10;
    private final Book[] books = new Book[SHELF_COUNT];
    private int bookCount = 0;

    public Book[] getBooks() {
        return books;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getEmptyShelfCount() {
        return books.length - bookCount;
    }

    public String addBook(Book book) {
        books[bookCount++] = book;
        return "\nКнига успешно добавлена!";
    }

    public Book find(Scanner scan) {
        if (bookCount == 0) {
            throw new NoSuchElementException("\nКнига не может быть найдена! Шкаф пуст.");
        }
        System.out.print("\nВведите название книги: ");
        String title = scan.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                return books[i];
            }
        }
        throw new NoSuchElementException("\nКнига не найдена!");
    }

    public String delete(Scanner scan) {
        if (bookCount == 0) {
            throw new NoSuchElementException("\nКнига не может быть удалена! Шкаф пуст.");
        }
        Book book;
        try {
            book = find(scan);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("\nКнига не найдена и не может быть удалена!");
        }
        for (int i = 0; i < bookCount; i++) {
            if (book.equals(books[i])) {
                if (i != books.length - 1) {
                    System.arraycopy(books, i + 1, books, i, (books.length - 1) - i);
                }
                books[bookCount - 1] = null;
                bookCount--;
                break;
            }
        }
        return "\nКнига успешно удалена!";
    }

    public String clearBookshelf() {
        if (bookCount == 0) {
            throw new NoSuchElementException("\nШкаф уже очищен!");
        }
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        return "\nШкаф успешно очищен!";
    }
}
