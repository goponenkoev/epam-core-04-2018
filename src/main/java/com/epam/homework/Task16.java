package com.epam.homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     *     ...
     *     case  -5: поворот на 450* против часовой стрелки
     *     case  -4: поворот на 360* против часовой стрелки
     *     case  -3: поворот на 270* против часовой стрелки
     *     case  -2: поворот на 180* против часовой стрелки
     *     case  -1: поворот на  90* против часовой стрелки
     *     case   0: поворот не осуществляется
     *     case   1: поворот на  90* по     часовой стрелке
     *     case   2: поворот на 180* по     часовой стрелке
     *     case   3: поворот на 270* по     часовой стрелке
     *     case   4: поворот на 360* по     часовой стрелке
     *     case   5: поворот на 450* по     часовой стрелке
     *     ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     *
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     *  1  -2   1
     * -3   0   2
     *  3  -2   1
     *  1
     *
     * Выходные данные:
     *  3
     *  3  -3   1
     * -2   0  -2
     *  1   2   1
     *
     *
     *
     * Входные данные:
     *  2
     *  9  3
     *  2  4
     * -2
     *
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        // TODO реализация
        try(Scanner scanner  = new Scanner(System.in)){
            int dimension = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, dimension);
            rotateMatrix(matrix, scanner.nextInt());
        }
    }

    private static void rotateMatrix(int[][] matrix, int k) {
        List<int[]> list = new LinkedList<>(Arrays.asList(matrix));
        if (k < 0){
            for (int i = 0; i < Math.abs(k); i++) {
                list = Arrays.asList(rotateMatrixLeft(list.toArray(new int[list.size()][])));
            }
        }else {
            for (int i = 0; i < k; i++) {
                list = Arrays.asList(rotateMatrixRight(list.toArray(new int[list.size()][])));
            }
        }
        matrix =  list.toArray(new int[list.size()][]);
        printMatrix(matrix);
    }

    private static void printMatrix(int [][] matrix) {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < matrix.length; ++col) {
                System.out.print(aMatrix[col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrixRight(int [][] matrix) {
        int [][] result = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                result[row][col] = matrix[matrix.length - col - 1][row];
            }
        }
        return result;
    }

    private static int[][] rotateMatrixLeft(int [][] matrix) {
        int [][] result = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                result[row][col] = matrix[col][matrix.length - row - 1];
            }
        }
        return result;
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
