package com.startjava.lesson_2_3_4.calculator.exception;

public class ExpressionLengthException extends RuntimeException {
    public ExpressionLengthException(String msg) {
        super(msg);
    }
}