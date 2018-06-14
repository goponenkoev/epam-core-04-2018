package com.epam.homework;

import java.util.Scanner;

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
     */
    public static void main(String[] args) {
        // TODO реализация
        try (Scanner scanner = new Scanner(System.in)) {
            int finalRow = scanner.nextInt();
            int finalCol = scanner.nextInt();

            Matrix matrix = new Matrix();
            matrix.readMatrix(scanner);
            matrix.moveMinElement(finalRow, finalCol);
            matrix.printMatrix();
        }
    }
}

class Matrix {

    private int[][] matrix;
    private int rowMin = 0;
    private int colMin = 0;

    Matrix() {
        matrix = new int[0][0];
    }

    void readMatrix(Scanner scanner) {
        int minValue = Integer.MAX_VALUE;
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

    void printMatrix() {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < matrix[0].length; ++col) {
                System.out.print(aMatrix[col] + "\t");
            }
            System.out.println();
        }
    }

    void moveMinElement(int finalRow, int finalCol) {
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