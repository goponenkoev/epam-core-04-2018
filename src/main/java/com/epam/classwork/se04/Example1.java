package com.epam.classwork.se04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Example1 {

    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("text.txt")))) {
            // создание потокового объекта (открытие потока)
            // работа с потоком через потоковый объект
            pw.println("I'm a sentence in a text-file.");
            pw.println("I'm a sentence in a text-file."); // <- throw IOException
            pw.println("I'm a sentence in a text-file.");
            pw.println("I'm a sentence in a text-file.");

            // закрытие потока

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
