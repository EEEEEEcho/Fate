package com.labuladong.chapter1.difference;

public class CarPooling {
    private int[] diff;

    public boolean carPooling(int[][] trips, int capacity) {
        diff = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            increment(trips[i][1],trips[i][2] - 1,trips[i][0]);
        }
        return getAnswer(capacity);
    }

    private void increment(int i,int j,int value){
        diff[i] += value;
        if (j + 1 < diff.length) diff[j + 1] -= value;
    }

    private boolean getAnswer(int cap){
        int[] ans = new int[diff.length];
        ans[0] = diff[0];
        if(ans[0] > cap) return false;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = diff[i + 1] + ans[i - 1];
            if (ans[i] > cap){
                return false;
            }
        }
        return true;
    }
}
