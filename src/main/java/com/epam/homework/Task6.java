package com.epam.homework;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     *
     * Выходные данные:
     * by
     *
     * ===================================================================================================
     *
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     *
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner( System.in )) {
            int number = Integer.valueOf( scanner.nextLine() );
            String res = "NOT FOUND";
            for (int i = 0; i < number; i++) {
                String temp = scanner.next();
                if ( checkOrder( temp ) && temp.length() > 1 ) {
                    res = temp;
                    break;
                }
            }
            System.out.println( res );
        }
    }

    private static boolean checkOrder(String temp) {
        for (int j = 0; j < temp.length() - 1; j++) {
            if ( temp.charAt( j ) >= temp.charAt( j + 1 ) ) return false;
        }
        return true;
    }
}
