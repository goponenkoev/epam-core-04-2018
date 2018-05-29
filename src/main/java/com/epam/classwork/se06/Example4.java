package com.epam.classwork.se06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example4 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Runnable task = new Runnable() {

            @Override
            public void run() {
                method1();
                method2();
            }

            private void method1() {
                System.out.println("From method1");
            }

            void method2() {

            }


        };

        Method method = task.getClass().getDeclaredMethod("method1");
        method.setAccessible(true);
        method.invoke(task);
//        System.out.println(Arrays.toString(task.getClass().getDeclaredMethods()));
//        tmp.run();
//        tmp.method1();
    }
}
