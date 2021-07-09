package com.code.ArrayTrain;

import java.util.*;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        if (treeSet.size() < 3){
            return treeSet.last();
        }
        treeSet.pollLast();
        treeSet.pollLast();
        Integer integer = treeSet.pollLast();
        return integer;
    }

}
