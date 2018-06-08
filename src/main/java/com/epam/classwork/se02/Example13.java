package com.epam.classwork.se02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Example13 {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, 2, -5, 0};
        Arrays.sort(arr);

        Comparator<IntHolder> reverseOrderComparator = new ReverseOrderComparator();
        IntHolder[] holders = {new IntHolder(1), new IntHolder(-1), new IntHolder(10)};
        Arrays.sort(holders, reverseOrderComparator);
        System.out.println(Arrays.toString(holders));


//        IntHolder left = new IntHolder(Integer.MIN_VALUE);
//        IntHolder right = new IntHolder(20);
//
//        int result = left.compareTo(right);'
    }
}


class ReverseOrderComparator implements Comparator<IntHolder> {

    @Override
    public int compare(IntHolder o1, IntHolder o2) {
        return Integer.compare(o2.getValue(), o1.getValue());
    }
}


class IntHolder implements Comparable<IntHolder> {

    private final int value;

    IntHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // > 0 == this >  other
    // 0   == this == other
    // < 0 == this <  other
    @Override
    public int compareTo(IntHolder other) {
        return Integer.compare(value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}