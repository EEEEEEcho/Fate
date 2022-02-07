package com.code.ArrayTrain;

public class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0){
            return m * n;
        }
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }
        return minx * miny;
    }
}
