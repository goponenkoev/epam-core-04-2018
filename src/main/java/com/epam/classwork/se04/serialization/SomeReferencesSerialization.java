package com.epam.classwork.se04.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SomeReferencesSerialization {

    public static void main(String[] args) {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Point p3 = new Point(3.0, 3.0);
        Line line1 = new Line(p1, p2, 1);
        Line line2 = new Line(p2, p3, 2);

        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);
        String fileName = "lines.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
             FileInputStream in = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(in)) {

            oos.writeInt(100);
            oos.flush();
//            line1.setId(3);
//            oos.reset();
//
//            oos.writeObject(line1);

            System.out.println("Read objects:");

            System.out.println(in.available());
            while (in.available() > 0) {
                int i = ois.readInt();
                System.out.println(i);
//                Line line = (Line) ois.readObject();
//                line.printInfo();
            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

