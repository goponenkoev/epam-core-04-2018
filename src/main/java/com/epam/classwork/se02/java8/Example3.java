package com.epam.classwork.se02.java8;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Comparator;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("all")
public class Example3 {

    public static void main(String[] args) {
        Comparator<String> lengthStringComparator = Example3::compareStringsLength;

        System.out.println("Hello, lambdas");
        Consumer<Object> sout = System.out::println;

        sout.accept("HEllo again");

        lengthStringComparator.compare("1", "232");

        Comparator<String> comparator = (String o1, String o2) -> {
            return Integer.compare(o1.length(), o2.length());
        };

        Random random = getRandom();
        Supplier<Integer> supplier1 = random::nextInt;

        supplier1.get();

        random = null;

        supplier1.get();


        Function<String, Person> factory = Person::new;
        PersonFactory factory1 = Person::new;
        Person person = factory.apply("name");
        System.out.println(person);

        BiConsumer<String, String> varargConsumer = Example3::varargMethod;


//        Supplier<Integer> supplier2 = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return random.nextInt();
//            }
//        };
    }

    public static void varargMethod(String...arg) {
        System.out.println(arg);
    }

    public static void varargMethod(String arg1, String arg2) {
    }

    @Value
    @AllArgsConstructor
    static class Person {
        String name;
        String surname;

        public Person(String name) {
            this.name = name;
            this.surname = "DEFAULT";
        }

        static Person getChild(String name) {
            return null;
        }
    }

    @FunctionalInterface
    interface PersonFactory {

        Person create(String name, String surname);
    }

    private static Random getRandom() {
        return new Random();
    }

    private static int compareStringsLength(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }

    private static void test(Comparator<String> a, Comparator<Integer> b) {

    }


    private static Comparator<String> getLengthStringComparator() {
        return (o1, o2) -> Integer.compare(o1.length(), o2.length()); // <- epxression-lambda
//        return (o1, o2) -> {   <- statement-lambda
//            sout("123");
//            return Integer.compare(o1.length(), o2.length());
//        };
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        };


    }


}
