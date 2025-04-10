package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.FullBookshelfException;
import java.util.Arrays;

public class Bookshelf {

    public static final int SHELF_COUNT = 10;
    private final Book[] books = new Book[SHELF_COUNT];
    private int shelfLen = 0;
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
        findMaxLen(book);
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
        for (int i = 0; i < bookCount; i++) {
            if (title.equals(books[i].getTitle())) {
                final int bookLen = books[i].toString().length();
                bookCount--;
                if (i != bookCount) {
                    System.arraycopy(books, i + 1, books, i, bookCount - i);
                }
                books[bookCount] = null;
                updateShelfLen(bookLen);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(books, 0, bookCount, null);
        bookCount = 0;
        Console.displayText("\nШкаф успешно очищен!\n");
    }

    private void updateShelfLen(int bookLen) {
        if (bookLen < shelfLen) return;
        shelfLen = 0;
        for (Book book : getBooks()) {
            findMaxLen(book);
        }
    }

    private void findMaxLen(Book book) {
        shelfLen = Math.max(shelfLen, book.toString().length());
    }
}
