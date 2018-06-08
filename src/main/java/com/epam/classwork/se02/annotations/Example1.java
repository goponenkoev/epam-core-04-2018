
package com.epam.classwork.se02.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@MyAnnotation(version = 10, name = "bb")
public class Example1 {


    @MyAnnotation(version = 30, name = "123")
    public static void main(@MyAnnotation(version = 20, name = "asd") String[] args) {
        System.out.println(Example1.class.isAnnotationPresent(MyAnnotation.class));
        MyAnnotation annotation = Example1.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.version());


        try {
            Method main = Example1.class.getMethod("main", String[].class);
            System.out.println(main.getDeclaredAnnotation(MyAnnotation.class).version());

            Annotation[] annotations = main.getParameterAnnotations()[0];
            MyAnnotation declaredAnnotation = main.getDeclaredAnnotation(MyAnnotation.class);
            MyAnnotation myAnnotation = (MyAnnotation) annotations[0];
            System.out.println(myAnnotation.version());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    int version();
    String name();
}

@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@interface PackageAnnotation {

}