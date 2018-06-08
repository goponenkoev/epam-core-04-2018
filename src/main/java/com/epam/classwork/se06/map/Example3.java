package com.epam.classwork.se06.map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Example3 {

    public static void main(String[] args) throws IOException {
        Properties systemProperties = System.getProperties();

        Properties properties = new Properties();
        properties.load(new FileReader("C:\\projects\\lectures\\repositories\\epam-core-2018-04\\src\\main\\resources\\prop.properties"));
        System.out.println(properties.getProperty("key"));

        for (Map.Entry<Object, Object> entry : systemProperties.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
