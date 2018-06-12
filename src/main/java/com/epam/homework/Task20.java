package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     *
     */
    public static void main(String[] args) {
        // TODO реализация
        Matrix matrix = new Matrix();
        matrix.moveMinElemenet();
        matrix.printMatrix();
    }
}

class Matrix {

    private int[][] matrix;
    private int rowMin = 0;
    private int colMin = 0;
    private int finalRow = 0;
    private int finalCol = 0;

    Matrix() {
        readMatrix();
    }

    private void readMatrix() {
        int minValue = Integer.MAX_VALUE;

        try (Scanner scanner = new Scanner(System.in)) {
            finalRow = scanner.nextInt();
            finalCol = scanner.nextInt();

            int dimension = scanner.nextInt();
            matrix = new int[dimension][dimension];
            for (int row = 0; row < dimension; ++row) {
                for (int col = 0; col < dimension; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    if (minValue > matrix[row][col]) {
                        minValue = matrix[row][col];
                        rowMin = row;
                        colMin = col;
                    }
                }
            }
        }
    }

    void printMatrix() {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < matrix[0].length; ++col) {
                System.out.print(aMatrix[col] + "\t");
            }
            System.out.println();
        }
    }

    void moveMinElemenet() {
        int[] tempRow = matrix[rowMin];
        matrix[rowMin] = matrix[finalRow];
        matrix[finalRow] = tempRow;

        for (int row = 0; row < matrix.length; row++) {
            int tempElement = matrix[row][colMin];
            matrix[row][colMin] = matrix[row][finalCol];
            matrix[row][finalCol] = tempElement;
        }
    }
}