package com.code.carl.array.rollmatrix;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int up = 0;
        int down = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        while (true){
            for (int i = left; i <= right; i++) {
                arr[up][i] = count++;
            }
            up ++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                arr[i][right] = count++;
            }
            right --;
            if (right < left) break;
            for (int i = right; i >= left ; i--) {
                arr[down][i] = count++;
            }
            down --;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                arr[i][left] = count ++;
            }
            left ++;
            if (left > right) break;
        }
        return arr;
    }
}
