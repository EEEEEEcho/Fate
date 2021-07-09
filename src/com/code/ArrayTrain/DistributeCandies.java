package com.code.ArrayTrain;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy: candyType) {
            set.add(candy);
        }
        if (set.size() > candyType.length / 2){
            return candyType.length / 2;
        }
        else{
            return set.size();
        }
    }
}
