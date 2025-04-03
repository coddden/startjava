package com.startjava.lesson_2_3_4.bookshelf;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BookshelfMain {

    private static final int MENU_START = 1;
    private static final int MENU_END = 5;
    private static final String MENU = """
                    \n
                    1.Добавить книгу
                    2.Найти книгу
                    3.Удалить книгу
                    4.Очистить шкаф
                    5.Завершить
                    
                    """;

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Bookshelf bookshelf1 = new Bookshelf();
        typeGreeting();
        int option = 0;
        while (option != MENU_END) {
            displayText("\nДля продолжения работы нажмите клавишу <Enter>");
            if (!scan.nextLine().isEmpty()) continue;
            if (bookshelf1.getBookCount() == 0) {
                displayText("\nШкаф пуст! Вы можете добавить в него первую книгу.");
            }
            if (bookshelf1.getBookCount() > 0) {
                displayText(createBookshelf(bookshelf1));
            }
            displayText(MENU);
            option = selectOption(scan);
            scan.nextLine();
            try {
                switch (option) {
                    case 1 -> displayText(bookshelf1.addBook(createBook(scan, bookshelf1)));
                    case 2 -> displayText("\n" + bookshelf1.find(scan) + "\n");
                    case 3 -> displayText(bookshelf1.delete(scan));
                    case 4 -> displayText(bookshelf1.clearBookshelf());
                }
            } catch (IllegalStateException | IllegalArgumentException |
                     NoSuchElementException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        displayText("\nПрограмма завершена!\n");
    }

    private static void typeGreeting() throws InterruptedException {
        for (char letter : "\nДобро пожаловать!".toCharArray()) {
            System.out.print(letter);
            Thread.sleep(200);
        }
    }

    public static String createBookshelf(Bookshelf bookshelf1) {
        StringBuilder bookshelf = new StringBuilder();
        bookshelf.append("\nВ шкафу книг - ").append(bookshelf1.getBookCount())
                .append(" | Свободных полок - ").append(bookshelf1.getEmptyShelfCount())
                .append("\n");
        for (int i = 0; i < bookshelf1.getBookCount(); i++) {
            bookshelf.append("\n").append("|").append(bookshelf1.getBooks()[i])
                    .append(" ".repeat(Bookshelf.SHELF_LENGTH - bookshelf1.getBooks()[i].toString().length()))
                    .append("|").append("\n").append("|").append("-".repeat(Bookshelf.SHELF_LENGTH))
                    .append("|");
        }
        return bookshelf.toString();
    }

    public static int selectOption(Scanner scan) {
        String msg = "Выберите пункт меню: ";
        int option;
        while (true) {
            displayText(msg);
            try {
                option = scan.nextInt();
            } catch (InputMismatchException e) {
                msg = "Ошибка: введите номер из списка: ";
                scan.nextLine();
                continue;
            }
            if (option < MENU_START || option > MENU_END) {
                msg = "Ошибка: введите номер из списка: ";
                continue;
            }
            return option;
        }
    }

    private static Book createBook(Scanner scan, Bookshelf bookshelf1) {
        if (bookshelf1.getBookCount() == Bookshelf.SHELF_COUNT) {
            throw new ArrayIndexOutOfBoundsException("\nВ шкафу закончилось место! " +
                    "Книга не может быть сохранена.");
        }
        String[] bookAttributes = {"Имя автора: ", "Название: ", "Год издания: "};
        System.out.println();
        for (int i = 0; i < bookAttributes.length; i++) {
            displayText(bookAttributes[i]);
            bookAttributes[i] = scan.nextLine();
        }
        Book book = new Book(bookAttributes);
        if (book.toString().length() > Bookshelf.SHELF_LENGTH) {
            throw new IllegalArgumentException("\nКнига не помещается на полку!");
        }
        return book;
    }

    private static void displayText(String text) {
        System.out.print(text);
    }
}
