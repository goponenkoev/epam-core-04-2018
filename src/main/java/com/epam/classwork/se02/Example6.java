package com.epam.classwork.se02;

import java.util.Objects;

public class Example6 {

    public static void main(String[] args) {
        boolean isEquals = new Pen().equals(new ColoredPen());

    }
}

class Pen {

    private double price;
    private String producerName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        return !(Math.abs(price - pen.price) < 0.000001)
            && Objects.equals(producerName, pen.producerName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (producerName != null ? producerName.hashCode() : 0);
        return result;
    }
}


class ColoredPen extends Pen {
    private int rgb;
}
