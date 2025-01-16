package com.startjava.lesson_2_3_4.method.naming;

public class BooleanMethods {
    public boolean shouldContinue() {
        System.out.print("\n\n\n" + MethodName.getCurrent() +
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasFile() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> в игре \"Марио\" остались попытки? ");
        return false;
    }

    public boolean isEmpty() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isFileExist() {
        System.out.print("\n\n" + MethodName.getCurrent() +
                "() -> файл по указанному адресу существует? ");
        return false;
    }
}
