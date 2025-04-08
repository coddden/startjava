package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.FullBookshelfException;
import java.util.Arrays;
import java.util.Comparator;

public class Bookshelf {

    public static final int SHELF_COUNT = 10;
    private final Book[] books = new Book[SHELF_COUNT];
    private int shelfLen;
    private int bookCount = 0;

    public Book[] getBooks() {
        return Arrays.copyOf(books, bookCount);
    }

    public int getShelfLen() {
        return shelfLen;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int countEmptyShelves() {
        return books.length - bookCount;
    }

    public void add(Book book) {
        if (bookCount >= SHELF_COUNT) {
            throw new FullBookshelfException("\nВ шкафу закончилось место! " +
                    "Книга не может быть сохранена.");
        }
        books[bookCount++] = book;
        calcShelfLen();
        Console.displayText("\nКнига успешно добавлена!\n");
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
                calcShelfLen();
                break;
            }
        }
        return true;
    }

    public void clearBookshelf() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        Console.displayText("\nШкаф успешно очищен!\n");
    }

    public void calcShelfLen() {
        Book[] booksCopy = Arrays.copyOf(books, bookCount);
        Arrays.sort(booksCopy, Comparator.comparing(o -> o.toString().length()));
        shelfLen = booksCopy[bookCount - 1].toString().length();
    }
}
