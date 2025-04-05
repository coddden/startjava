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
        Bookshelf bookshelf = new Bookshelf();
        typeGreeting();
        int menuItem = 0;
        while (menuItem != MENU_END) {
            displayText("\nДля продолжения работы нажмите клавишу <Enter>");
            if (!scan.nextLine().isEmpty()) continue;
            displayOverview(bookshelf);
            menuItem = selectMenuItem(scan);
            scan.nextLine();
            try {
                choseAction(scan, bookshelf, menuItem);
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

    private static void displayOverview(Bookshelf bookshelf) {
        displayText(bookshelf.getBookCount() > 0 ? createBookshelf(bookshelf) :
                "\nШкаф пуст! Вы можете добавить в него первую книгу.");
        displayText(MENU);
    }

    public static String createBookshelf(Bookshelf bookshelf) {
        StringBuilder bookshelfState = new StringBuilder();
        bookshelfState.append("\nВ шкафу книг - ").append(bookshelf.getBookCount())
                .append(" | Свободных полок - ").append(bookshelf.countEmptyShelves())
                .append("\n");
        for (Book book : bookshelf.getBooks()) {
            int spacesCount = Bookshelf.SHELF_LEN - book.toString().length();
            bookshelfState.append("\n|").append(book).append(" ".repeat(spacesCount)).append("|")
                    .append("\n|").append("-".repeat(Bookshelf.SHELF_LEN)).append("|");
        }
        return bookshelfState.toString();
    }

    public static int selectMenuItem(Scanner scan) {
        String msg = "Выберите пункт меню: ";
        int menuItem;
        while (true) {
            displayText(msg);
            try {
                menuItem = scan.nextInt();
            } catch (InputMismatchException e) {
                msg = "Ошибка: введите номер из списка: ";
                scan.nextLine();
                continue;
            }
            if (menuItem < MENU_START || menuItem > MENU_END) {
                msg = "Ошибка: введите номер из списка: ";
                continue;
            }
            return menuItem;
        }
    }

    private static void choseAction(Scanner scan, Bookshelf bookshelf, int menuItem) {
        switch (menuItem) {
            case 1 -> {
                if (bookshelf.add(createBook(scan))) {
                    displayText("\nКнига успешно добавлена!\n");
                }
            }
            case 2 -> {
                System.out.print("\nВведите название книги: ");
                Book book = bookshelf.find(scan.nextLine());
                displayText(book == null ?
                        "\nКнига не найдена!\n" :
                        "\n" + book + "\n");
            }
            case 3 -> {
                System.out.print("\nВведите название книги: ");
                displayText(bookshelf.delete(scan.nextLine()) ?
                        "\nКнига успешно удалена!\n" :
                        "\nКнига не найдена и не может быть удалена!\n");
            }
            case 4 -> {
                bookshelf.clearBookshelf();
                displayText("\nШкаф успешно очищен!\n");
            }
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
