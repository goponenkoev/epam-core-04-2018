package com.epam.classwork.se04;

import java.io.IOException;
import java.util.Scanner;

public class Example6 {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(Integer.parseInt(scanner.nextLine()));
            System.out.println(scanner.nextLine());
        }
        System.in.read();
    }

}
