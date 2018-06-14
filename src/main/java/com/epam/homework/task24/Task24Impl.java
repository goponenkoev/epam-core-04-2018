package com.epam.homework.task24;

import java.util.HashMap;
import java.util.Map;

public class Task24Impl implements Task24{
    @Override
    public Map<Integer, Integer> addPolynomials(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> resultMap = new HashMap<>(first);

        for (Map.Entry cur: second.entrySet()){
            resultMap.computeIfAbsent((Integer)cur.getKey(), (val) -> (Integer)cur.getValue());
            resultMap.computeIfPresent((Integer)cur.getKey(), (key, val) -> (Integer)cur.getValue() + val);
        }

        return resultMap;
    }

}
