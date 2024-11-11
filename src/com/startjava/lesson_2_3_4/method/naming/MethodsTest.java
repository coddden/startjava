package com.startjava.lesson_2_3_4.method.naming;

public class MethodsTest {
    public static void main(String[] args) {
        MethodsTest methodsTest = new MethodsTest();
        methodsTest.doNonBooleanMethods();
        methodsTest.doBooleanMethods();
    }

    public void doNonBooleanMethods() {
        NonBooleanMethods nonBooleanMethods = new NonBooleanMethods();
        nonBooleanMethods.findLongestWord();
        nonBooleanMethods.selectMenuItem();
        nonBooleanMethods.calcAverage();
        nonBooleanMethods.countUniqueWords();
        nonBooleanMethods.displayErrorMessage();
        nonBooleanMethods.syncCloud();
        nonBooleanMethods.recoverBackup();
        nonBooleanMethods.suspendDownload();
        nonBooleanMethods.resetToFactorySettings();
        nonBooleanMethods.writeToFile();
        nonBooleanMethods.convertToFahrenheit();
        nonBooleanMethods.enterMathExp();
        nonBooleanMethods.determineWinner();
        nonBooleanMethods.findBook();
    }

    public void doBooleanMethods() {
        BooleanMethods booleanMethods = new BooleanMethods();
        System.out.print(booleanMethods.shouldContinue());
        System.out.print(booleanMethods.hasFile());
        System.out.print(booleanMethods.hasUniqueDigit());
        System.out.print(booleanMethods.isLetter());
        System.out.print(booleanMethods.hasEqualDigits());
        System.out.print(booleanMethods.hasAttempts());
        System.out.print(booleanMethods.isEmpty());
        System.out.print(booleanMethods.isEven());
        System.out.print(booleanMethods.isValidPath());
        System.out.print(booleanMethods.isFileExist() + "\n\n\n");
    }
}