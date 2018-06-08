package com.epam.classwork.se05;

import java.io.IOException;
import java.io.InputStream;

public class Example8 {

    public static void main(String[] args) {
        InputStream throwableStream = new InputStream() {
            @Override
            public int read() throws IOException {
                throw new IOException("From read");
            }

            @Override
            public void close() throws IOException {
                throw new IOException("From close");
            }
        };


        try (throwableStream) {
            throwableStream.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.err.println("123");
        }
    }
}
