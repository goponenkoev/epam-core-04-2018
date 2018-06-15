package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task15 {

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     *  3
     *  1   0   3
     * -1   2   2
     *  1  -1   3
     *
     * Выходные данные:
     * -1
     */
    public static void main(String[] args) {
        // TODO реализация
        try(Scanner scanner  = new Scanner(System.in)){
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            System.out.println(findSum(matrix, dimension));
        }
    }

    private static int findSum(int[][] matrix, int dimension) {
        int sum = 0;
        int index = 0;
        int count = 1;
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                if ((matrix[row][col] > 0)) {
                    if (count == 2){
                        sum+= getSumFromRow(matrix[row], index, col);
                        break;
                    }
                    count++;
                    index = col;
                }
            }
            count = 1;
            index = 0;
        }
        return sum;
    }

    private static int getSumFromRow(int[] matrix, int index, int col) {
        int sum = 0;
        for (int i = index + 1; i < col; i++) {
            sum+= matrix[i];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner, int dimension) {

        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
