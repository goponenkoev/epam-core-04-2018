package com.epam.homework;

import java.util.*;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {
        // TODO реализация
        Matrix matrix = new Matrix();
        matrix.removeRowColoumns();
        matrix.printMatrix();
    }

}

class Matrix {

    private int[][] matrix;
    private Set<Integer> indexOfRow = new HashSet<>();
    private Set<Integer> indexOfColumn = new HashSet<>();
    private int rows;
    private int columns;
    private int max = Integer.MIN_VALUE;

    Matrix() {
        readMatrix();
    }

    private void readMatrix() {
        try (Scanner scanner = new Scanner(System.in)) {
            rows = columns = scanner.nextInt();
            matrix = new int[rows][columns];
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < columns; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    if (max < matrix[row][col]) {
                        max = matrix[row][col];
                    }
                }
            }
        }
    }

    void printMatrix() {
        System.out.println(rows);
        System.out.println(columns);
        for (int[] aMatrix : matrix) {
            for (int col = 0; col < columns; ++col) {
                System.out.print(aMatrix[col] + "\t");
            }
            System.out.println();
        }
    }

    void removeRowColoumns() {
        int maxElemenet = max;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < columns; ++col) {
                if (maxElemenet == matrix[row][col]) {
                    indexOfRow.add(row);
                    indexOfColumn.add(col);
                }
            }
        }
        removeColumns();
        removeRows();
    }

    private void removeRows() {
        int[][] newMatrx = new int[rows - indexOfRow.size()][columns];
        for (int i = 0, j = 0; i < rows - indexOfRow.size(); i++, j++) {
            while (indexOfRow.contains(j)) {
                j++;
            }
            newMatrx[i] = Arrays.copyOf(matrix[j], matrix[j].length);
        }
        matrix = newMatrx;
        rows-=indexOfRow.size();
    }

    private void removeColumns() {
        int[][] newMatrx = new int[rows][columns - indexOfColumn.size()];
        for (int j = 0, k = 0; j < columns - indexOfColumn.size(); j++, k++) {
            while (indexOfColumn.contains(k)) {
                k++;
            }
            for (int i = 0; i < rows; i++) {
                newMatrx[i][j] = matrix[i][k];
            }
        }
        matrix = newMatrx;
        columns-=indexOfColumn.size();
    }
}