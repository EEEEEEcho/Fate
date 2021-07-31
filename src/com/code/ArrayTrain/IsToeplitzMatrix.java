package com.code.ArrayTrain;

public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length <= 1){
            return true;
        }
//        for(int i = 0,j = 0;i < matrix.length - 1;i ++){
//            if (j + 1 == matrix[0].length){
//                j = 0;
//                i -= 1;
//                continue;
//            }
//            if (matrix[i][j] != matrix[i + 1][j + 1]){
//                return false;
//            }
//            j ++;
//        }
//        for (int i = 0,j = 1;j < matrix[0].length - 1;j ++){
//            if (i + 1 == matrix.length){
//                i = 0;
//                j -= 1;
//                continue;
//            }
//            if (matrix[i][j] != matrix[i + 1][j + 1]){
//                return false;
//            }
//            i ++;
//        }
//        return true;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < matrix.length){
            while (k + 1 < matrix.length && j + 1 < matrix[0].length){
                if (matrix[k][j] != matrix[k + 1][j + 1]){
                    return false;
                }
                k ++;
                j ++;
            }
            i ++;
            k = i;
            j = 0;
        }
        int l = 1;
        int m = 0;
        int n = 1;
        while (l < matrix[0].length){
            while (m + 1 < matrix.length && n + 1 < matrix[0].length){
                if (matrix[m][n] != matrix[m + 1][n + 1]){
                    return false;
                }
                m ++;
                n ++;
            }
            l ++;
            m = 0;
            n = l;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0,j = 0;i < 3;i ++,j ++){
            if (i == 2){
                i -= 1;
                System.out.println("执行continue");
                continue;
            }
            System.out.println(i);
            System.out.println(j);
        }
    }
}
