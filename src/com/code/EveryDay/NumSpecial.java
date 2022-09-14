package com.code.EveryDay;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1){
                    if (isSpecial(mat,i,j)){
                        count ++;
                    }
                }
            }
        }
        return count;
    }
    public boolean isSpecial(int[][] mat,int i,int j){
        boolean row = true;
        boolean col = true;
        for (int m = 0;m < mat[0].length;m ++){
            if (m == j) continue;
            if (mat[i][m] == 1) {
                col = false;
                break;
            }
        }

        for (int n = 0; n < mat.length; n++) {
            if (n == i) continue;
            if (mat[n][j] == 1){
                row = false;
                break;
            }
        }

        return row && col;
    }
}
