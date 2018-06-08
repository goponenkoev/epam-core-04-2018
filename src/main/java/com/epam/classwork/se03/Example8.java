package com.epam.classwork.se03;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Example8 {

    public static void main(String[] args) {
        String pattern01 = "<+";
        String pattern02 = "<?";
        String pattern03 = "<*";

        String str = "<body><h1> a<<<b </h1></body>";
        String[] result;

        result = Pattern.compile(pattern01).split(str);
        // ""|body>|h1> a|b |/h1>|/body>|
        printTokens(result);

        result = Pattern.compile(pattern02).split(str);
        // ""|""|b|o|d|y|>|""|h|1|>| |a|""|""|""|b| |""|/|h|1|>|""|/|b|o|d|y|>|
        printTokens(result);

        result = Pattern.compile(pattern03).split(str);
        // ""|""|b|o|d|y|>|""|h|1|>| |a|""|b| |""|/|h|1|>|""|/|b|o|d|y|>|

        printTokens(result);
    }

    public static void printTokens(String[] tokens) {
        Arrays.stream(tokens)
              .map(str -> str.isEmpty() ? "\"\"" : str)
              .map(str -> str + "|")
              .forEachOrdered(System.out::print);
    }
}
