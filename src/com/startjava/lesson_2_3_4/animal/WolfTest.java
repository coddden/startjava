package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf mrGray = new Wolf();

        mrGray.setName("Mr Gray");
        mrGray.setGender("самец");
        mrGray.setColor("серый");
        mrGray.setAge(8);
        mrGray.setWeight(80.5f);

        System.out.println("\nИмя волка: " + mrGray.getName());
        System.out.println("Пол волка: " + mrGray.getGender());
        System.out.println("Цвет волка: " + mrGray.getColor());
        System.out.println("Возраст волка: " + mrGray.getAge());
        System.out.println("Вес волка: " + mrGray.getWeight());

        mrGray.walk();
        mrGray.sit();
        mrGray.run();
        mrGray.howl();
        mrGray.hunt();
    }
}