package com.code.EveryDay;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0){
            return 0;
        }
        if (start > destination){
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int n = distance.length;
        int sum1 = 0;
        int sum2 = 0;
        int index = start;
        while (index != destination){
            sum1 += distance[index];
            index = (index + 1) % n;
        }
        while (index != start){
            sum2 += distance[index];
            index = (index + 1) % n;
        }
        return Math.min(sum1,sum2);
    }
}
