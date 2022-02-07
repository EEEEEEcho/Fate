package com.code.HeapTrain;

import java.util.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(stones.length, Comparator.reverseOrder());
        for(Integer integer : stones){
            priorityQueue.offer(integer);
        }
        while (priorityQueue.size() > 1){
            int weight = priorityQueue.poll();
            int next = priorityQueue.poll();
            if(weight != next){
                priorityQueue.offer(weight - next);
            }
        }
        if (priorityQueue.size() == 1){
            return priorityQueue.poll();
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
