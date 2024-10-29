public class GameAssistant {
    public boolean shouldContinue() {
        System.out.print("\n\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> программа выполняется далее или завершается? ");
        return false;
    }

    public boolean hasFile() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> удалился ли файл на жестком диске или флешке? ");
        return false;
    }

    public boolean hasUniqueDigit() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> пользователь ввел букву или что-то другое? ");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> в проверяемых числах, есть равные цифры? ");
        return false;
    }

    public boolean hasAttempts() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> в игре \"Марио\" остались попытки? ");
        return false;
    }

    public boolean hasWhitespace() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEven() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return false;
    }

    public boolean isFileExist() {
        System.out.print("\n\n" + NamePrompter.getCurrentMethodName() +
                "() -> файл по указанному адресу существует? ");
        return false;
    }
}
