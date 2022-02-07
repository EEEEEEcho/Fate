package com.labuladong.chapter1.prenum;

public class NumMatrix {
    private int[][] preNums;
    public NumMatrix(int[][] matrix) {
        this.preNums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < preNums.length; i++) {
            for (int j = 1;j < preNums[0].length;j ++){
                preNums[i][j] = preNums[i - 1][j] + preNums[i][j - 1]
                        + matrix[i - 1][j - 1] - preNums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNums[row2 + 1][col2 + 1] - preNums[row2][col1] - preNums[row1][col2] + preNums[row1][col1];
    }
}
