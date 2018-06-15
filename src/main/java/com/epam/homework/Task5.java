package com.epam.homework;

import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита
     * и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     * <p>
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        int n = Integer.parseInt( scanner.next() );
        int numWords = 0;
        int numConsonants;
        int numVowels;

        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            numVowels = 0;
            numConsonants = 0;
            if ( temp.matches( "^[a-zA-Z]+$" ) && (temp.length() % 2 == 0) ) {
                for (int j = 0; j < temp.length(); j++) {
                    if ( Character.toString( temp.charAt( j ) ).matches( "(?i:[aeiouy]).*" ) ) {
                        numConsonants++;
                    } else {
                        numVowels++;
                    }
                }
                if ( numVowels == numConsonants ) {
                    numWords++;
                }
            }
        }
        System.out.println( numWords );
    }
}
