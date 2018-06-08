package com.epam.classwork.se06.map;

import lombok.Value;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example1 {

    public static void main(String[] args) {
        Queue<Pen> queue = new PriorityQueue<>(Comparator.comparing(Pen::getManufacturer));
        queue.add(new Pen("a", 10));
        queue.add(new Pen("d", 9));
        queue.add(new Pen("c", 20));
        queue.add(new Pen("b", 15));

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

@Value
class Pen implements Comparable<Pen> {
    String manufacturer;
    int price;

    @Override
    public int compareTo(Pen o) {
        return Integer.compare(price, o.price);
    }
}
