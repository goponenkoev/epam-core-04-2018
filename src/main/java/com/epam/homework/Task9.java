package com.epam.homework;

import java.util.Locale;
import java.util.Scanner;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     *
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     *
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     *
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     *
     * ------------------------------------------------------------------------------ ---------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 2 7 0
     *
     * Выходные данные:
     * -3.50, 0.00
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     *
     * Выходные данные:
     * -0.50
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     *
     * Выходные данные:
     * NO ROOTS
     */
    public static void main(String[] args) {
        // TODO реализация
        try (Scanner scanner = new Scanner(System.in)) {
            int coeffA = scanner.nextInt();
            int coeffB = scanner.nextInt();
            int coeffC = scanner.nextInt();
            System.out.println(solve(coeffA, coeffB, coeffC));
        }
    }

    private static String solve(int a, int b, int c) {
        double di = Math.pow(b, 2) - 4 * a * c;
        if (Double.compare(di, 0) == 0) {
            double root = (-b + Math.sqrt(di)) / (2 * a);
            return String.format(Locale.ENGLISH, "%.2f", root);
        } else if (Double.compare(di, 0) > 0) {
            double root1 = (-b - Math.sqrt(di)) / (2 * a);
            double root2 = (-b + Math.sqrt(di)) / (2 * a);
            return String.format(Locale.ENGLISH, "%.2f, %.2f", root1, root2);
        } else {
            return "NO ROOTS";
        }
    }
}
