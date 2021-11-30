package com.labuladong.chapter1.difference;

public class CorpFlightBookings {
    private int[] diff;
    public int[] corpFlightBookings(int[][] bookings, int n) {
        diff = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            increment(bookings[i][0] - 1,bookings[i][1] - 1,bookings[i][2]);
        }
        return getResult();
    }
    private void increment(int i,int j,int value){
        diff[i] += value;
        if (j + 1 < diff.length) diff[j + 1] -= value;
    }
    private int[] getResult(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
