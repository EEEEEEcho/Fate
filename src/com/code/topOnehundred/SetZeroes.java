package com.code.topOnehundred;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean[][] mark = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !mark[i][j]){
                    mark[i][j] = true;
                    int m = i;
                    int n = j;
                    int x = i;
                    int y = j;
                    while (m < matrix.length){
                        if (matrix[m][j] == 0 && !mark[m][j]){
                            m ++;
                            continue;
                        }
                        matrix[m][j] = 0;
                        mark[m][j] = true;
                        m ++;
                    }
                    while (x >= 0){
                        if (matrix[x][j] == 0 && !mark[x][j]){
                            x --;
                            continue;
                        }
                        matrix[x][j] = 0;
                        mark[x][j] = true;
                        x --;
                    }
                    while (n < matrix[0].length){
                        if (matrix[i][n] == 0 && !mark[i][n]){
                            n ++;
                            continue;
                        }
                        matrix[i][n] = 0;
                        mark[i][n] = true;
                        n ++;
                    }
                    while (y >= 0){
                        if (matrix[i][y] == 0 && !mark[i][y]){
                            y --;
                            continue;
                        }
                        matrix[i][y] = 0;
                        mark[i][y] = true;
                        y --;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(new int[][]{
                {0,1,2,0},{3,4,5,2},{1,3,1,5}
        });
    }
}
