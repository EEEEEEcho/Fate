package com.code.carl.array.rollmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (true){
            for (int i = left; i <= right ; i++) {
                list.add(matrix[up][i]);
            }
            up ++;
            if (up > down) break;
            for (int i = up; i <= down ; i++) {
                list.add(matrix[i][right]);
            }
            right --;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down --;
            if (down < up) break;
            for (int i = down; i >= up ; i--) {
                list.add(matrix[i][left]);
            }
            left ++;
            if (left > right) break;
        }
        return list;
    }
}
