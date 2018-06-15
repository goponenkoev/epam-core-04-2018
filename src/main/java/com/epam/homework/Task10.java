package com.epam.homework;

import java.util.Scanner;

public class Task10 {

    /**
     * Ввести число с консоли.
     * С помощью битовых, логических и арифметических операций определить, является ли указанное значение степенью двойки.
     *
     * Формат входных данных:
     * value - целое число (Integer.MIN_VALUE <= value <= Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * YES - число является степенью двойки
     * NO - число не является степенью двойки
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * -128
     *
     * Выходные данные:
     * NO
     *
     *
     * Входные данные:
     * 256
     *
     * Выходные данные:
     * YES
     */
    public static void main(String[] args) {
        // TODO реализация
        try(Scanner scnaner = new Scanner(System.in)){
            int value = scnaner.nextInt();
            System.out.println(checkPowerOfTwo(value));
        }

    }

    private static String checkPowerOfTwo(int value) {
        return (((value & (value - 1)) == 0) && (value > 0)) ? "YES" :"NO";
    }
}
