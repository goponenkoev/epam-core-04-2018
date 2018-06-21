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

    private static int countOverTaing(Car firstCar, Car secondCar, int distance, int lapLength){
        int result = 0;
        int timeFirstCar = distance / firstCar.getSpeed();
        int timeSecondCar = distance / secondCar.getSpeed();
        int difference = (distance - Math.min(firstCar.getSpeed(), secondCar.getSpeed()) * Math.min(timeFirstCar, timeSecondCar));

        result += Math.abs(difference / lapLength);

        if ((firstCar.getStartPosition() < secondCar.getStartPosition()) && (secondCar.getSpeed() > firstCar.getSpeed())) {
            ++result;
        }
        if ((firstCar.getStartPosition() > secondCar.getStartPosition()) && (secondCar.getSpeed() < firstCar.getSpeed())) {
            ++result;
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
