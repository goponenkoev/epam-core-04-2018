package com.epam.classwork.se01;

/**
 * 12312
 * @version 1.0
 */
public class Example5 {


    // Integer
    // header : 16b
    // value  :  4b
    // padding:  4b

    // ref -> 8b
    public static void main(String[] args) {
        int value = 0xFFFFFFFF;
        System.out.println(value >>>= 1);
        System.out.println(value << 3);

        int numberBits = Integer.bitCount(value);

        short one = -1;
//        one >>>= (Short.BYTES * 8) + 10;
//        one /= 1 << 10;

//        System.out.println(one);


        // 11111111
        byte b = -1;


        // 1111.....111111111 <- 32
        // 00000000001111...1 <- 32
        // 11111111
        b >>>= 10;
        System.out.println(b);
        b = -1;
        System.out.println(b >>> 10);


        //        example1();
    }

    private static void example1() {
        Integer a = 10;

        method(a++);
        method(++a);


        int mask = 0b111;
        // 00000.....111
        // &
        // 0000000000001
        // =
        // 0000000000001
        System.out.println(mask & 0b1);
        System.out.println(mask &= 0b1);
        System.out.println(mask);
        System.out.println("qwe");
    }


    /**
     *
     * @param value qweqwe
     * @return wewe
     * @throws IllegalStateException qwe
     * @see Math
     */
    public static int method(int value) throws IllegalStateException {
        System.out.println(value);
        return 42;
    }
}
