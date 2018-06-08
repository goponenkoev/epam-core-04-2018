package com.epam.classwork.se02.enums;

import java.util.Comparator;

public class Example1 {

    static final int WINTER_TEMPERATURE = -1;

    public static void main(String[] args) {

        Season season = Season.WINTER;
        System.out.println(season);
        System.out.println(season.temperature());
        System.out.println(Season.SUMMER.temperature());

        Season.WINTER.setTemperature(1);
        System.out.println(season.temperature());

        switch (season) {
            case AUTUMN:
                System.out.println("1");
                break;

            case SPRING:
                System.out.println("2");
                break;
        }

        System.out.println(Season.WINTER.hashCode());

        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer);

        Comparator<String> comparator = Season.WINTER;

    }

    public static int getWinterTemperature() {
        return -2;
    }
}

enum Season implements Comparator<String> {
    WINTER(Example1.getWinterTemperature()) {
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    },
    SPRING(12) {
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    },
    SUMMER(26) {
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    },
    AUTUMN(15) {
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    };

    @Override
    public String toString() {
        return "I'm: " + super.toString().toLowerCase() + "!";
    }


    protected int temperature;

    Season(int temperature) {
        this.temperature = temperature;
    }

    public int temperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public abstract int compare(String o1, String o2);
}

enum Persons {
    PERSON_1(new Person()),
    PERSON_2(new Person()),
    PERSON_3(new Person()),
    PERSON_4(new Person());

    private final Person person;

    Persons(Person person) {
        this.person = person;
    }
}

class Person {

    enum Types {
        TYPE1,
        TYPE2;
    }
}