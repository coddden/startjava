package com.startjava.lesson_2_3_4.bookshelf;

import java.util.InputMismatchException;
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
                    case 1 -> {
                        if (bookshelf1.addBook(createBook(scan))) {
                            displayText("\nКнига успешно добавлена!\n");
                        }
                    }
                    case 2 -> {
                        System.out.print("\nВведите название книги: ");
                        Book book = bookshelf1.find(scan.nextLine());
                        displayText(book == null ?
                                "\nКнига не найдена!\n" :
                                "\n" + book + "\n");
                    }
                    case 3 -> {
                        System.out.print("\nВведите название книги: ");
                        displayText(bookshelf1.delete(scan.nextLine()) ?
                                "\nКнига успешно удалена!\n" :
                                "\nКнига не найдена и не может быть удалена!\n");
                    }
                    case 4 -> {
                        if (bookshelf1.clearBookshelf()) {
                            displayText("\nШкаф успешно очищен!\n");
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
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
                .append(" | Свободных полок - ").append(bookshelf1.countEmptyShelves())
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

    private static Book createBook(Scanner scan) {
        String[] bookAttributes = {"Имя автора: ", "Название: ", "Год издания: "};
        System.out.println();
        for (int i = 0; i < bookAttributes.length; i++) {
            displayText(bookAttributes[i]);
            bookAttributes[i] = scan.nextLine();
        }
        return new Book(bookAttributes);
    }

    private static void displayText(String text) {
        System.out.print(text);
    }
}
