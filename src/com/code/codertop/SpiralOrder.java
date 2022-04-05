package com.code.codertop;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int up = 0;
        int down = matrix.length;
        List<Integer> list = new ArrayList<>();
        while (true){
            //先横着走
            for (int i = left; i < right; i++) {
                list.add(matrix[up][i]);
            }
            //第一行处理完了
            up ++;
            if (up >= down) break;
            //竖着走
            for (int i = up;i < down;i ++){
                list.add(matrix[i][right - 1]);
            }
            //最后一列处理完了
            right --;
            if (right <= left) break;
            //向左走
            for (int i = right - 1; i > left ; i--) {
                list.add(matrix[down - 1][i]);
            }
            //最后一行处理完了
            down ++;
            if (down <= up) break;
            //向上走
            for (int i = down + 1; i > up; i--) {
                list.add(matrix[i][left]);
            }
            //最左边的处理完了
            left ++;
            if (left >= right) break;
        }
        return list;
    }
}
