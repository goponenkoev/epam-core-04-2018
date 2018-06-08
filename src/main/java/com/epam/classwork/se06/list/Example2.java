package com.epam.classwork.se06.list;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class Example2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        // elementData.length == 5
        // cursor = 0

        // elementData.length == 5
        // cursor = 1

        // elementData.length == 5
        // cursor = 2

        // elementData.length == 4
        // cursor = 3

        // elementData.length == 4
        // cursor = 4


        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer current = iterator.next();
            if (current > 4) {
//                list.remove(current);
                iterator.remove();
            }
        }


        List<Person> persons = null;
        persons.removeIf(person -> person.getAge() > 18);

        list.removeIf(value -> value > 4);
        System.out.println(list);


//        for (Integer curr : list) {
//            if (curr > 3) {
//                list.remove(curr);
//                System.out.println(list);
//            }
//        }
    }
}


@Getter
class Person {

    int age;
}



















