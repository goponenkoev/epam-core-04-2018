package com.epam.classwork.se03.encoding;

public class Example1 {

    public static void main(String[] args) {
        String str = "\uD86A\uDFCE-\uD86A\uDFCE !";
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, str.length()));

        String anotherString = "123abcerer";
        for (char c : anotherString.toCharArray()) {

        }

        for (int i = 0; i < anotherString.codePointCount(0, anotherString.length()); ++i) {
            int letter = anotherString.codePointAt(i);
            if (letter > 10000) {
                System.out.println(letter);
            }
        }

        anotherString.chars()
                     .filter(sym -> sym > 10000)
                     .forEachOrdered(System.out::println);

    }


    // 0 - 255 <- 1 байт
    // 0 - 127
    // 0.......
    // 110xxxxx 10xxxxxx
}
