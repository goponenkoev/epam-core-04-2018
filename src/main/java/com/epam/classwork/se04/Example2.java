package com.epam.classwork.se04;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Example2 {

    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();

        PipedWriter writer = new PipedWriter(reader);
//        writer.write('!');


        System.out.println((char)reader.read());


    }

}
