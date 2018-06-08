package com.epam.classwork.se07.concurrent;

public class Example10 {

    public static void main(String[] args) {
        String word = "abc";
        int encode = getEncode(word);

        String another = "cde";
        int enc = getEncode(another);

        // 0xFFFF FFFF

        System.out.println((encode & 0xFFFF) == (enc >> 16));


    }

    private static int getEncode(String word) {
        return word.charAt(0) << 16 | word.charAt(word.length() - 1);
    }
}
