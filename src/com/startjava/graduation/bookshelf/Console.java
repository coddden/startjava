package com.startjava.graduation.bookshelf;

public class Console {

    private static final int TYPE_TIME = 200;
    private static final String MENU = """
                    \n
                    1.Добавить книгу
                    2.Найти книгу
                    3.Удалить книгу
                    4.Очистить шкаф
                    5.Завершить
                    
                    """;

    private Console() {}

    public static void displayOverview(Bookshelf bookshelf, String bookshelfState) {
        displayText(bookshelf.getBookCount() > 0 ? bookshelfState :
                "\nШкаф пуст! Вы можете добавить в него первую книгу.");
        displayText(MENU);
    }

    public static void displayText(String text) {
        System.out.print(text);
    }

    public static void typeText(String text) throws InterruptedException {
        for (char letter : text.toCharArray()) {
            System.out.print(letter);
            Thread.sleep(TYPE_TIME);
        }
    }
}
