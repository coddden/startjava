package com.startjava.lesson_2_3_4.person;

public class Person {

    String name = "John";
    String gender = "male";
    float height = 190.5f;
    float weight = 90.4f;
    int age = 25;

    public void walk() {
        System.out.println("John ходит");
    }

    public void sit() {
        System.out.println("John сидит");
    }

    public void run() {
        System.out.println("John бегает");
    }

    public void speak() {
        System.out.println("John говорит");
    }

    public void learnJava() {
        System.out.println("John учит Java");
    }
}