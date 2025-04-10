package com.startjava.graduation.bookshelf;

import com.startjava.graduation.bookshelf.exception.FullBookshelfException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        Console.typeText("\nДобро пожаловать!");
        MenuItem menuItem;
        do {
            waitToContinue(scan);
            Console.displayOverview(bookshelf, createBookshelf(bookshelf));
            menuItem = selectItem(scan);
            scan.nextLine();
            try {
                executeAction(scan, bookshelf, menuItem);
            } catch (FullBookshelfException | IllegalArgumentException e) {
                Console.displayText(e.getMessage());
            }
        } while (menuItem != MenuItem.EXIT);
        Console.displayText("\nПрограмма завершена!\n");
    }

    private static void waitToContinue(Scanner scan) {
        do {
            Console.displayText("\nДля продолжения работы нажмите клавишу <Enter>");
        } while (!scan.nextLine().isEmpty());
    }

    public static String createBookshelf(Bookshelf bookshelf) {
        int shelfLen = bookshelf.getShelfLen();
        StringBuilder bookshelfState = new StringBuilder();
        bookshelfState.append("\nВ шкафу книг - ").append(bookshelf.getBookCount())
                .append(" | Свободных полок - ").append(bookshelf.countEmptyShelves())
                .append("\n");
        for (Book book : bookshelf.getBooks()) {
            int spacesCount = shelfLen - book.toString().length();
            bookshelfState.append("\n|").append(book).append(" ".repeat(spacesCount)).append("|")
                    .append("\n|").append("-".repeat(shelfLen)).append("|");
        }
        return bookshelfState.toString();
    }

    public static MenuItem selectItem(Scanner scan) {
        String msg = "Выберите пункт меню: ";
        MenuItem menuItem;
        while (true) {
            Console.displayText(msg);
            try {
                menuItem = MenuItem.getName(scan.nextInt());
            } catch (InputMismatchException | IllegalArgumentException e) {
                msg = "Ошибка: введите номер из списка: ";
                scan.nextLine();
                continue;
            }
            return menuItem;
        }
    }

    private static void executeAction(Scanner scan, Bookshelf bookshelf, MenuItem menuItem) {
        switch (menuItem) {
            case ADD -> bookshelf.add(createBook(scan));
            case FIND -> find(scan, bookshelf);
            case DELETE -> delete(scan, bookshelf);
            case CLEAR -> bookshelf.clear();
        }
    }

    private static Book createBook(Scanner scan) {
        String[] bookAttributes = {"Имя автора: ", "Название: ", "Год издания: "};
        System.out.println();
        for (int i = 0; i < bookAttributes.length; i++) {
            Console.displayText(bookAttributes[i]);
            bookAttributes[i] = scan.nextLine();
        }
        return new Book(bookAttributes);
    }

    private static void find(Scanner scan, Bookshelf bookshelf) {
        Console.displayText("\nВведите название книги: ");
        Book book = bookshelf.find(scan.nextLine());
        Console.displayText(book == null ?
                "\nКнига не найдена!\n" :
                "\n" + book + "\n");
    }

    private static void delete(Scanner scan, Bookshelf bookshelf) {
        Console.displayText("\nВведите название книги: ");
        Console.displayText(bookshelf.delete(scan.nextLine()) ?
                "\nКнига успешно удалена!\n" :
                "\nКнига не найдена и не может быть удалена!\n");
    }
}