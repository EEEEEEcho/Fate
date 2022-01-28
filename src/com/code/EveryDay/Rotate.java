package com.code.EveryDay;

public class Rotate {
    public void rotate(int[][] matrix) {
//        int row = matrix.length;
//        int row = 0;
//        int col = matrix.length - 1;
//        while (row < matrix.length && col >= 0){
//            for (int i = col,j = col; i >=0 && j >= 0; i--,j--) {
//                int temp = matrix[row][i];
//                matrix[row][i] = matrix[col][j];
//                matrix[j][col] = temp;
//            }
//            row ++;
//            col --;
//        }
//        int rows = matrix.length;
//        for (int i = 0; i < rows; i++) {
//            int[] row = matrix[i];
//
//        }
        int[][] tmpMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tmpMatrix[i][j] = matrix[i][j];
            }
        }
        //int col = matrix[0].length - 1;
        for (int i = 0,col = matrix[0].length - 1; i < matrix.length && col >= 0; i++,col--) {
            int[] row = matrix[i];
            for (int j = matrix.length - 1;j >= 0;j --){
                matrix[col][j] = row[j];
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.rotate(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        });
    }
}
