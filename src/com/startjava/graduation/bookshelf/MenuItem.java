package com.startjava.graduation.bookshelf;

public enum MenuItem {

    ADD(1),
    FIND(2),
    DELETE(3),
    CLEAR(4),
    EXIT(5);

    private final int item;

    MenuItem(int item) {
        this.item = item;
    }

    public static MenuItem getMenuItemName(int num) {
        if (num < ADD.item || num > EXIT.item) {
            throw new IllegalArgumentException("\nОшибка: введите номер из списка: ");
        }
        return MenuItem.values()[num - 1];
    }
}
