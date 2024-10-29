public class AssistantTest {
    public static void main(String[] args) {
        StudentAssistant studentAssistant = new StudentAssistant();
        GameAssistant gameAssistant = new GameAssistant();

        AssistantTest assistantTest = new AssistantTest();
        assistantTest.callStudentAssistant(studentAssistant);
        assistantTest.callGameAssistant(gameAssistant);
    }

    public void callStudentAssistant(StudentAssistant studentAssistant) {
        studentAssistant.findLongestWord();
        studentAssistant.pickMenuItem();
        studentAssistant.calcAverage();
        studentAssistant.countUniqueWords();
        studentAssistant.displayErrorMessage();
        studentAssistant.synchCloud();
        studentAssistant.recoverBackup();
        studentAssistant.suspendDownload();
        studentAssistant.resetToFactorySettings();
        studentAssistant.writeToFile();
        studentAssistant.convertToFahrenheit();
        studentAssistant.enterMathExp();
        studentAssistant.identifyWinner();
        studentAssistant.findBook();
    }

    public void callGameAssistant(GameAssistant gameAssistant) {
        System.out.print(gameAssistant.shouldContinue());
        System.out.print(gameAssistant.hasFile());
        System.out.print(gameAssistant.hasUniqueDigit());
        System.out.print(gameAssistant.isLetter());
        System.out.print(gameAssistant.hasEqualDigits());
        System.out.print(gameAssistant.hasAttempts());
        System.out.print(gameAssistant.hasWhitespace());
        System.out.print(gameAssistant.isEven());
        System.out.print(gameAssistant.isValidPath());
        System.out.print(gameAssistant.isFileExist() + "\n\n\n");
    }
}