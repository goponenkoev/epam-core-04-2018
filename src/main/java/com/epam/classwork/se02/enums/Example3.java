package com.epam.classwork.se02.enums;

public class Example3 {

    public static void main(String[] args) {
        Direction opposite = Direction.BACKWARD.opposite();
    }

}

enum Direction {

    FORWARD(1.0) {
        @Override
        public Direction opposite() {
            return null;
        }
    },
    BACKWARD(2.0) {
        public Direction opposite() {
            return FORWARD;
        }
    };

    private double ratio;

    public abstract Direction opposite();

    Direction(double r) {
        ratio = r;
    }

    public double getRatio() {
        return ratio;
    }

    public static Direction byRatio(double r) {
        if (r == 1.0)	return FORWARD;
        else if (r == 2.0) return BACKWARD;
        else throw new IllegalArgumentException();
    }
}

