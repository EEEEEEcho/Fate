package com.qiye;

import java.util.HashMap;
import java.util.Map;

/**
 * 最短路径问题
 */
public class TheBagProblem {
    public static void main(String[] args) {

    }
    public static int method(int diamondCount,int knapsackCapacity,int []weights,int counts[]){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i < diamondCount;i ++){
            map.put(counts[i],weights[i]);
        }
        System.out.println(map);
        return 0;
    }
}
