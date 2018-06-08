package com.epam.classwork.se04;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {
        performTask(() -> {
            byte[] input = ("1 2" + System.lineSeparator()).getBytes();

            System.setIn(new ByteArrayInputStream(input));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));

            solution();

            assert "3".equals(out.toString().trim());
        });
    }

    private static void performTask(Runnable task) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            task.run();
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        System.out.println(Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]));

        Scanner anotherScanner = new Scanner(System.in);
        System.out.println(anotherScanner.nextLine());
    }
}
