package com.epam.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     *
     * Выходные данные:1
     * 22
     */
    public static void main(String[] args) {
        // TODO реализация
        try (Scanner scanner = new Scanner(System.in)) {
            int num = Integer.parseInt(scanner.nextLine());
            List<String> words = Arrays.asList(scanner.nextLine().split(" ", num));
            System.out.println(findResult(words));
        }

    }

    private static String findResult(List<String> words) {
        String res = "NOT FOUND";
        int count = 0;
        for (String word : words) {
            if (isPolyndrom(word) && !res.equals(word)) {
                res = word;
                count++;
            }
            if (count > 1) {
                break;
            }
        }
        return res;
    }

    private static boolean isPolyndrom(String temp) {
        return isNumber(temp) && temp.equals((new StringBuilder(temp)).reverse().toString());
    }

    private static boolean isNumber(String temp) {
        if (temp == null || temp.isEmpty()) return false;
        for (int i = 0; i < temp.length(); i++) {
            if (!Character.isDigit(temp.charAt(i))) return false;
        }
        return true;
    }
}
