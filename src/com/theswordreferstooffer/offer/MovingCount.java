package com.theswordreferstooffer.offer;

public class MovingCount {
    public int movingCount(int threshold,int rows,int cols){
        int[][] flg = new int[rows][cols];
        return helper(0,0,rows,cols,flg,threshold);
    }
    private int helper(int i,int j,int rows,int cols,int[][] flg,int threshold){
        //如果所走的格子越界 或者所走格子的和超过了要求的和 或者所走格子以前来过
        if(i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flg[i][j] == 1){
            return 0;
        }
        flg[i][j] = 1;  //标记当前来过
        return helper(i - 1,j,rows,cols,flg,threshold) + helper(i + 1,j,rows,cols,flg,threshold) +
                helper(i,j-1,rows,cols,flg,threshold) + helper(i,j + 1,rows,cols,flg,threshold) + 1;
    }
    private int numSum(int i){
        int sum = 0;
        while (i > 0){
            sum += i % 10;
            i = i/ 10;
        }
        return sum;
    }
}
