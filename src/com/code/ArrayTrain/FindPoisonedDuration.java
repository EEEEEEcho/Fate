package com.code.ArrayTrain;

public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] < duration){
                result += timeSeries[i + 1] - timeSeries[i];
            }
            else{
                result += duration;
            }
        }
        return result + duration;
    }
}
