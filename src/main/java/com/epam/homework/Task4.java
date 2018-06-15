package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        Integer num = scanner.nextInt();
        scanner.nextLine();

        if ( num > 0 ) {
            String[] words = new String[num];

            for (int i = 0; i < num; i++) {
                words[i] = scanner.next();
            }
            System.out.println( findWorld( words ) );
        }
    }

    private static String findWorld(String[] words) {
        String res = words[0];
        int count = Integer.MAX_VALUE;
        for (String curr : words) {
            Set<Character> setUniqueChar = new HashSet<>();

            for (int i = 0; i < curr.length(); i++) {
                setUniqueChar.add( curr.charAt( i ) );
            }

            if ( count > setUniqueChar.size() ) {
                count = setUniqueChar.size();
                res = curr;
            }
        }
        return res;
    }
}

