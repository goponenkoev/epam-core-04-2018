package com.epam.classwork.se03.encoding;

import java.util.Locale;
import java.util.ResourceBundle;

public class Example7 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println(Locale.getDefault());

        ResourceBundle strings = ResourceBundle.getBundle("bundles.register.my strings");
        System.out.println(strings.getString("button.another"));
    }
}
