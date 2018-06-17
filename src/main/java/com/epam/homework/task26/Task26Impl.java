package com.epam.homework.task26;

import java.util.*;

public class Task26Impl implements Task26 {

    /**
     * На плоскости задано N отрезков (2 <= N <= 20).
     * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
     * Использовать класс TreeMap.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        Set<I2DPoint> finalSet = new HashSet<>();
        ISegment[] array = segments.toArray(new ISegment[0]);
        TreeMap<ISegment, Set<I2DPoint>> treeMap = new TreeMap<>(Comparator.comparingLong(Object::hashCode));

        double intersectionMin = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            Set<I2DPoint> intersectionSet = new HashSet<>();
            for (int j = i + 1; j < array.length; j++) {
                I2DPoint intersectionPoint = intersection(array[i], array[j]);
                if (intersectionPoint == null) continue;
                if (Double.compare(intersectionPoint.getX(), intersectionMin) <= 0) {
                    intersectionMin = intersectionPoint.getX();
                }
                intersectionSet.add(intersectionPoint);
            }
            treeMap.put(array[i], intersectionSet);
        }

        for (Set<I2DPoint> set : treeMap.values()) {
            for (I2DPoint point : set) {
                if (Double.compare(point.getX(), intersectionMin) == 0) {
                    finalSet.add(point);
                }
            }
        }

        return finalSet;
    }

    private static I2DPoint intersection(ISegment segment1, ISegment segment2) {

        I2DPoint dir1 = new Point(segment1.second().getX() - segment1.first().getX(), segment1.second().getY() - segment1.first().getY());
        I2DPoint dir2 = new Point(segment2.second().getX() - segment2.first().getX(), segment2.second().getY() - segment2.first().getY());

        double a1 = -dir1.getY();
        double b1 = dir1.getX();
        double d1 = -(a1 * segment1.first().getX() + b1 * segment1.first().getY());

        double a2 = -dir2.getY();
        double b2 = dir2.getX();
        double d2 = -(a2 * segment2.first().getX() + b2 * segment2.first().getY());

        double seg1_start = a2 * segment1.first().getX() + b2 * segment1.first().getY() + d2;
        double seg1_end = a2 * segment1.second().getX() + b2 * segment1.second().getY() + d2;

        double seg2_start = a1 * segment2.first().getX() + b1 * segment2.first().getY() + d1;
        double seg2_end = a1 * segment2.second().getX() + b1 * segment2.second().getY() + d1;

        if (seg1_start * seg1_end > 0 || seg2_start * seg2_end > 0)
            return null;

        double u = seg1_start / (seg1_start - seg1_end);
        return new Point(segment1.first().getX() + u * dir1.getX(), segment1.first().getY() + u * dir1.getY());
    }

}

/**
 * Точка на двумерной плоскости.
 */
class Point implements Task26.I2DPoint {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Значение абсциссы
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * Значение ординаты
     */
    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

/**
 * Отрезок.
 */
class Segment implements Task26.ISegment {

    private Task26.I2DPoint first;
    private Task26.I2DPoint second;

    Segment(Task26.I2DPoint first, Task26.I2DPoint second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @return Первая точка отрезка.
     */
    @Override
    public Task26.I2DPoint first() {
        return first;
    }

    /**
     * @return Вторая точка отрезка.
     */
    @Override
    public Task26.I2DPoint second() {
        return second;
    }
}
