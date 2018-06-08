package com.epam.classwork.se05;

import java.io.FileNotFoundException;

public class Example2 {

    /**
     *
     * @param args
     * @throws ArithmeticException
     * @throws NullPointerException
     */
    public static void main(String[] args) throws ArithmeticException, NullPointerException {
        try {
            method1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        method2();
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static void method2() throws FileNotFoundException, ClassNotFoundException {
        try {
            System.out.println("Before");
            if (true) {
                throw new FileNotFoundException();
            }
            System.out.println("After");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw ex;
        }
        throw new ClassNotFoundException();
    }
}