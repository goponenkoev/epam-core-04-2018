package com.epam.classwork.se04.serialization;

public class Line implements java.io.Serializable {

    private Point point1;
    private Point point2;
    private int id;

    public Line() {
        System.out.println("Constructing empty line");
    }

    Line(Point p1, Point p2, int id) {
        System.out.println("Constructing line: " + id);
        this.point1 = p1;
        this.point2 = p2;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int newIndex) {
        id = newIndex;
    }

    public void printInfo() {
        System.out.println("Line: " + id);
        System.out.println(" Object reference: " + super.toString());
        System.out.println(" from point " + point1);
        System.out.println(" to point " + point2);
    }
}
