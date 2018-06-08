package com.epam.classwork.se02.enums;

public class Example2 {

    public static void main(String[] args) {
        Season[] values = Season.values();
        Season season = Season.valueOf("SUMMER");

        Season season1 = Enum.valueOf(Season.class, "SUMMER");
        System.out.println(season == season1);

        System.out.println(Season.SUMMER.ordinal());

        switch (season.ordinal()) {
            case 2:
                System.out.println("I'm summer");
        }
    }
}
