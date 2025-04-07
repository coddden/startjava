package com.startjava.lesson_2_3_4.bookshelf;

import com.startjava.lesson_2_3_4.exception.FullBookshelfException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfMain {

    private static final int MENU_SIZE = 5;

    public enum MenuItems {
        ITEM_1(1),
        ITEM_2(2),
        ITEM_3(3),
        ITEM_4(4),
        ITEM_5(5);

        private final int num;

        MenuItems(int num) {
            this.num = num;
        }

        public static MenuItems fromItem(int num) {
            for (MenuItems item : values()) {
                if (item.num == num) return item;
            }
            throw new IllegalArgumentException("Ошибка: введите номер из списка: ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Bookshelf bookshelf = new Bookshelf();
        Console.typeText("\nДобро пожаловать!");
        MenuItems menuItem;
        do {
            waitToContinue(scan);
            Console.displayOverview(bookshelf, createBookshelf(bookshelf));
            menuItem = selectMenuItem(scan);
            scan.nextLine();
            try {
                choseAction(scan, bookshelf, menuItem);
            } catch (FullBookshelfException | IllegalArgumentException e) {
                Console.displayText(e.getMessage());
            }
        } while (menuItem.num != MENU_SIZE);
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

    public static MenuItems selectMenuItem(Scanner scan) {
        String msg = "Выберите пункт меню: ";
        MenuItems menuItem;
        while (true) {
            Console.displayText(msg);
            try {
                menuItem = MenuItems.fromItem(scan.nextInt());
            } catch (InputMismatchException | IllegalArgumentException e) {
                msg = "Ошибка: введите номер из списка: ";
                scan.nextLine();
                continue;
            }
            return menuItem;
        }
    }

    private static void choseAction(Scanner scan, Bookshelf bookshelf, MenuItems menuItem) {
        switch (menuItem) {
            case ITEM_1 -> bookshelf.add(createBook(scan));
            case ITEM_2 -> {
                Console.displayText("\nВведите название книги: ");
                Book book = bookshelf.find(scan.nextLine());
                Console.displayText(book == null ?
                        "\nКнига не найдена!\n" :
                        "\n" + book + "\n");
            }
            case ITEM_3 -> {
                Console.displayText("\nВведите название книги: ");
                Console.displayText(bookshelf.delete(scan.nextLine()) ?
                        "\nКнига успешно удалена!\n" :
                        "\nКнига не найдена и не может быть удалена!\n");
            }
            case ITEM_4 -> bookshelf.clearBookshelf();
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
}
