package com.theswordreferstooffer.offer;

import java.util.ArrayList;

public class ClockwisePrintMatrix {
    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     * 打印 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
     * //模拟
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return arrayList;
        }
        int rStart = 0,rEnd = matrix.length - 1;
        int cStart = 0,cEnd = matrix[0].length - 1;
        while (rStart <= rEnd && cStart <= cEnd){
            //从左往右
            for(int c = cStart; c <= cEnd; c++){
                arrayList.add(matrix[rStart][c]);
            }
            //从上往下
            for(int r = rStart + 1; r <= rEnd; r ++){
                arrayList.add((matrix[r][cEnd]));
            }
            //判断是否会重复
            if(rStart < rEnd && cStart < cEnd){
                //从右往左
                for(int c = cEnd - 1; c >= cStart;c--){
                    arrayList.add(matrix[rEnd][c]);
                }
                //从下往上
                for(int r = rEnd - 1;r > rStart;r --){
                    arrayList.add(matrix[r][cStart]);
                }
            }
            rStart ++;
            rEnd --;
            cStart ++;
            cEnd --;
        }
        return arrayList;
    }
}
