package com.code.topOnehundred;

public class MaximalSquare {
    //超时
    public int maximalSquare(char[][] matrix) {
//        boolean isAllZero = true;
//        for (char[] chars : matrix) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (chars[j] == '1') {
//                    isAllZero = false;
//                    break;
//                }
//            }
//        }
//        if (isAllZero) return 0;
        int k = Math.min(matrix.length,matrix[0].length);
        while (k >= 1){
            for (int i = 0; i <= matrix.length - k; i++) {
                for (int j = 0; j <= matrix[0].length - k; j++) {
                    if (isSquare(matrix,i,j,k)){
                        return k * k;
                    }
                }
            }
            k --;
        }
        return 0;
    }
    public boolean isSquare(char[][] matrix,int startX,int startY,int k){
        for (int i = startX; i < startX + k; i++) {
            for (int j = startY; j < startY + k; j++) {
                if (matrix[i][j] == '0') return false;
            }
        }
        return true;
    }
    //动态规划，有时候，子问题并不是简单的将原问题进行分解。而是需要提炼
    public int maximalSquare1(char[][] matrix) {
        //dp[i][j]表示的是，以matrix[i - 1][j - 1]作为右下角的正方形的最大边长
        int max = 0;
        //定义为 + 1 为了方便处理边界
        int m = matrix.length + 1;
        int n = matrix[0].length + 1;
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i][j - 1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
