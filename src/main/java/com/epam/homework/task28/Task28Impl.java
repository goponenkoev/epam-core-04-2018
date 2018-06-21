package com.epam.homework.task28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task28Impl implements Task28{
    @Override
    public int getNumberOvertaking(Set<Car> cars, int lapLength, int lapsCount) {
        List<Car> listCars = new ArrayList<>(cars);
        int distance = lapLength * lapsCount;
        int overTakingCount = 0;

        for (int i = 0; i < listCars.size(); i++) {
            for (int j = i + 1; j < listCars.size(); j++) {
                overTakingCount+=countOverTaing(listCars.get(i), listCars.get(j), distance, lapLength);
            }
        }
        return overTakingCount;
    }

    private static int countOverTaing(Car first, Car second, int distance, int length){
        int result = 0;
        int timeFirstCar = distance / first.getSpeed();
        int timeSecondCar = distance / second.getSpeed();
        int difference = (distance - Math.min(first.getSpeed(), second.getSpeed()) * Math.min(timeFirstCar, timeSecondCar));

        result += Math.abs(difference / length);

        if ((first.getStartPosition() < second.getStartPosition()) && (second.getSpeed() > first.getSpeed())) {
            result += 1;
        }
        if ((first.getStartPosition() > second.getStartPosition()) && (second.getSpeed() < first.getSpeed())) {
            result += 1;
        }
        return result;
    }



}

class CarImpl implements Task28.Car {

    private int position;
    private int speed;

    CarImpl(int p, int s){
        this.position = p;
        this.speed = s;
    }

    @Override
    public int getStartPosition() {
        return position;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
