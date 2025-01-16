package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger strikerEureka = new Jaeger();

        strikerEureka.setModelName("Striker Eureka");
        strikerEureka.setMark("Mark-5");
        strikerEureka.setSpeed(10);
        strikerEureka.setStrength(10);
        strikerEureka.setArmor(9);
        strikerEureka.setKaijuKilled(11);

        Jaeger gipsyDanger = new Jaeger("Gipsy Danger", "Mark-3", 7, 8, 6, 9);

        System.out.printf("%nМодель: %23s %15s",
                strikerEureka.getModelName(), gipsyDanger.getModelName());
        System.out.printf("%nМарк:%18s%18s", strikerEureka.getMark(), gipsyDanger.getMark());
        System.out.printf("%nСкорость:%10d%17d", strikerEureka.getSpeed(), gipsyDanger.getSpeed());
        System.out.printf("%nСила:%14d%17d", strikerEureka.getStrength(), gipsyDanger.getStrength());
        System.out.printf("%nБроня:%12d%18d", strikerEureka.getArmor(), gipsyDanger.getArmor());
        System.out.printf("%nУбитых Кайдзю:%5d%17d%n",
                strikerEureka.getKaijuKilled(), gipsyDanger.getKaijuKilled());
        System.out.println();

        strikerEureka.move();
        strikerEureka.drift();
        System.out.println();
        gipsyDanger.move();
        gipsyDanger.drift();
    }
}