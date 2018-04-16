package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1 {
    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     * <p>
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     * <p>
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */
    public static void main(String[] args) throws IOException {
        int numString;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        String inputString;
        StringBuilder maxString = new StringBuilder( );
        StringBuilder minString = new StringBuilder( );
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numString = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numString; i++) {
            inputString = reader.readLine();
            if (maxLength <= inputString.length()) {
                maxString.delete( 0, maxString.length() );
                maxString.replace( 0,inputString.length(),inputString );
                maxLength = maxString.length();
            }
            if (minLength >= inputString.length()) {
                minString.delete( 0, minString.length() );
                minString.append( inputString );
                minLength = minString.length();
            }
        }
        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }
}
