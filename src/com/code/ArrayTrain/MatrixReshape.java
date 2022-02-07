package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.List;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int col = mat[0].length;
        int row = mat.length;
        if (col * row != r * c){
            return mat;
        }
        List<Integer> list = new ArrayList<>();
        for (int[] ints : mat) {
            for (int j = 0; j < col; j++) {
                list.add(ints[j]);
            }
        }
        int[][] result = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = list.get(k);
                k ++;
            }
        }
        return result;
    }

    /**
     * 二维数组扁平化为一维数组
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape2(int[][] mat, int r, int c){
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c){
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < row * col; i++) {
            result[i / c][i % c] = mat[i / col][i % col];
        }
        return result;
    }
}
