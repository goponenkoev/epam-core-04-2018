package com.epam.classwork.se06.list;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.function.ToIntFunction;

public class Example5 {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
    }

    private static int[][] sortMatrix1(int[][] matrix, int column) {
        Arrays.sort(matrix, Comparator.comparingInt(o -> o[column]));
        return matrix;
    }

    private static int[][] sortMatrix2(int[][] matrix, int col) {
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[col], o2[col]);
            }
        });
        return matrix;
    }
}

class Stack {

    private final int[] values;

    private int cursor = 0;

    Stack(int size) {
        values = new int[size];
    }

    public void push(int value) {
        values[cursor++] = value;
    }

    public int pop() {
        return values[cursor--];
    }

}
