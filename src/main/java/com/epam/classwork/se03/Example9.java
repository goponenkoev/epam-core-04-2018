package com.epam.classwork.se03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example9 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher1 = pattern.matcher("123");
        System.out.println(matcher1.matches());

        Matcher matcher2 = pattern.matcher("123 qwe");
        System.out.println(matcher2.matches());
        System.out.println(matcher2.lookingAt());

        String input = "123 qwe 567 xcc 000";
        Matcher matcher3 = pattern.matcher(input);
        System.out.println(matcher3.matches());
        System.out.println(matcher3.lookingAt());
        matcher3.reset();
        System.out.println(matcher3.find());
        System.out.println(matcher3.start());
        System.out.println(matcher3.end());
        System.out.println(input.substring(matcher3.start(), matcher3.end()));


        System.out.println(matcher3.find());
        System.out.println(matcher3.group(0));
        System.out.println(matcher3.end());
        System.out.println(matcher3.find());
        System.out.println(matcher3.find());
    }

}














