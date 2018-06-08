package com.epam.classwork.se04.serialization;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class Point implements Serializable {

    private double x;
    private double y;

    public String toString() {
        return "(" + x + "," + y + ") reference=" + super.toString();
    }
}
