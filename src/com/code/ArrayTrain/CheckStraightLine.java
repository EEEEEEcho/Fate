package com.code.ArrayTrain;

public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2){
            return true;
        }
        int ky = coordinates[1][1] - coordinates[0][1];
        int kx = coordinates[1][0] - coordinates[0][0];
        if(kx == 0){
            for (int i = 1; i < coordinates.length; i++) {
                if(coordinates[i][0] - coordinates[i - 1][0] != 0){
                    return false;
                }
            }
            return true;
        }
        else{
            for (int i = 1; i < coordinates.length; i++) {
                int tmpx = coordinates[i][0] - coordinates[i - 1][0];
                if (tmpx == 0){
                    return false;
                }
                int tmpy = coordinates[i][1] - coordinates[i - 1][1];
                //int类型除法，想要获取double类型的结果，必须要将参与除法运算的两个int都变为double类型
                double i1 = (double) ky / (double) kx;
                double i2 = (double) tmpy / (double) tmpx;
                if(i1 != i2){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        new CheckStraightLine().checkStraightLine(new int[][]{
                {-4,-3},{1,0},{3,-1},{0,-1},{-5,2}
        });
    }
}
