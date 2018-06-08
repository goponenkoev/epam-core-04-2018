package com.epam.classwork.se01;

import java.util.Objects;

public class Example8 {

    public static void main(String[] args) {
        String a = "end1";
        String b = "end" + getValue();
        String c = b.intern();

        final int intValue = 1;
        System.out.println("end1" == "end" + intValue);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);


        final String perm = "ja";
        final String gen = "va";
        String permGen = perm + gen;
        String internedPermGen = permGen.intern();
        System.out.println(permGen == internedPermGen);





        //        example1();

    }

    private static int getValue() {
        return 1;
    }

    private static void example1() {
        IntHolder ref = new IntHolder(42);
        printValue(ref);



        String string = new String("End");
        System.out.println("End" == string);
        System.out.println("End".equals(string));
        System.out.println(1 + 2 + "abc" + ref + 4);
    }

    private static void printValue(IntHolder obj) {
        System.out.println(obj.getValue());
    }

}

class IntHolder {

    private int value = 42;

    public IntHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        int var = 444;
        return value;
    }

    @Override
    public String toString() {
        return "IntHolder[" + value + "]";
    }
}
