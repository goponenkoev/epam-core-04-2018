package com.epam.classwork.se05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("ALL")
public class Example6 {

    public static void main(String[] args) throws IOException {
        method();
    }

    private static void method() throws IOException {
        InputStream stream = null;
        IOException ex = null;
        try {
            stream = new FileInputStream("123");
            System.out.println("Before exception");
            if (true) {
                stream.read();
            }
            System.out.println("After exception");
        } catch (IOException e) {
            ex = e;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException closeEx) {
                    if (ex != null) {
                        closeEx.initCause(ex);
                    }
                    throw closeEx;
                }
            }
        }

        try (InputStream stream1 = null) {
            stream1.read();
        }
    }
}
