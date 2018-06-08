package com.epam.classwork.se03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example10 {

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("(\\d+) (\\d+)").matcher("asdas 123 566 adasd");
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.groupCount());

        matcher.reset("123 7877");
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));

        System.out.println(matcher.replaceAll("qwe"));

        Matcher matcher1 = Pattern.compile("^Java").matcher("qw");
        matcher1.find();
        System.out.println(matcher1.group());
    }

}
