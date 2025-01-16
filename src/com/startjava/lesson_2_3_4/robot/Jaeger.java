package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String modelName;
    private String mark;
    private int speed;
    private int strength;
    private int armor;
    private int kaijuKilled;

    public Jaeger() {}

    public Jaeger(String modelName, String mark, int speed,
            int strength, int armor, int kaijuKilled) {
        this.modelName = modelName;
        this.mark = mark;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
        this.kaijuKilled = kaijuKilled;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getKaijuKilled() {
        return kaijuKilled;
    }

    public void setKaijuKilled(int kaijuKilled) {
        this.kaijuKilled = kaijuKilled;
    }

    public void drift() {
        System.out.println("Пилоты " + modelName + " вошли в дрифт");
    }

    public void move() {
        System.out.println(modelName + " сделал 5 шагов");
    }
}