package com.epam.classwork.se01;

public class Example10 {

    public static void main(String[] args) {
        Example9 example9 = new Example9();
        switch (example9.VERSION) {
            case "1.0.1":
                System.out.println("123");
                break;

            case "1.0.2":
                System.out.println("abc");
                break;

            default:
                System.out.println("default");
        }
    }
}
