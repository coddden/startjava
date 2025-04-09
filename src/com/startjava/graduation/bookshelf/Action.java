package com.startjava.graduation.bookshelf;

public enum Action {

    ADD(1),
    FIND(2),
    DELETE(3),
    CLEAR(4),
    EXIT(5);

    private final int num;

    Action(int num) {
        this.num = num;
    }

    public static Action getAction(int num) {
        if (num < ADD.num || num > EXIT.num) {
            throw new IllegalArgumentException();
        }
        return Action.values()[num - 1];
    }
}
