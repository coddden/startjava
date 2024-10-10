public class WolfTest {
    public static void main(String[] args) {
        Wolf mrGrey = new Wolf();

        mrGrey.name = "Mr Grey";
        mrGrey.gender = "самец";
        mrGrey.colour = "серый";
        mrGrey.age = 8;
        mrGrey.weight = 80.5f;

        System.out.println("\nИмя волка: " + mrGrey.name);
        System.out.println("Пол волка: " + mrGrey.gender);
        System.out.println("Цвет волка: " + mrGrey.colour);
        System.out.println("Возраст волка: " + mrGrey.age);
        System.out.println("Вес волка: " + mrGrey.weight);

        mrGrey.walk();
        mrGrey.sit();
        mrGrey.run();
        mrGrey.howl();
        mrGrey.hunt();
    }
}