package com.epam.classwork.se04;

import java.io.*;
import java.nio.charset.Charset;

public class Example3 {

    final FileOutputStream outFile = new FileOutputStream("test.txt");
    final FileInputStream inFile = new FileInputStream("test.txt");

    public Example3() throws FileNotFoundException {
    }

    public void main(String[] args) {
        byte[] bytesToWrite = {1, 2, 3};
        byte[] bytesReaded = new byte[10];
        String fileName = "test.txt";

        try (outFile; inFile) {
            System.out.println("Файл открыт для записи");
            // Записать массив
            outFile.write(bytesToWrite);
            System.out.println("Записано: " + bytesToWrite.length + " байт");

            System.out.println("Файл открыт для чтения");
            // Узнать, сколько байт готово к считыванию
            int bytesAvailable = inFile.available();
            System.out.println("Готово к считыванию: " + bytesAvailable + " байт");
            // Считать в массив
            int count = inFile.read(bytesReaded, 0, bytesAvailable);
            System.out.println("Считано: " + count + " байт");
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }
}
