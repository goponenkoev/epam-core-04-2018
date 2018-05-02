package com.epam.homework;

import java.util.*;

public class Task13 {

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     *
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     *
     *
     *
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     *
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        // TODO реализация
        try(Scanner scanner  = new Scanner(System.in)){
            int[][] matrix = readMatrix(scanner);
            printMatrix(shiftRows(matrix, scanner.nextInt()));
        }
    }

    private static int[][] shiftRows(int[][] matrix, int k) {
        List<int[]> list = new LinkedList<>(Arrays.asList(matrix));
        for (int i = 0; i < Math.abs(k); i++) {
            if (k < 0){
                int[] temp = list.remove(0);
                list.add(temp);
            }else{
                int[] temp = list.remove(list.size() - 1);
                list.add(0, temp);
            }
        }
        matrix =  list.toArray(new int[list.size()][]);
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(aMatrix[col] + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
