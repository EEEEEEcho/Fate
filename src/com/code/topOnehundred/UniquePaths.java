package com.code.topOnehundred;

public class UniquePaths {
    private int count = 0;
    //动态规划，递推方程：(x,y) = (x - 1,y) + (x,y - 1)
    public int uniquePaths(int m, int n) {
//        dfs(0,0,m,n);
//        return count;
//        return compute(m,n);
        int range = Math.max(m,n);
        int[][] array = new int[range][range];
        array[0][0] = 1;
        for (int i = 1; i < range; i++) {
            array[0][i] = 1;
        }
        for (int i = 1; i < range; i++) {
            array[i][0] = 1;
        }
        for (int i = 1; i < range; i++) {
            for (int j = 1; j < range; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m][n];
    }
    //超时
    public int compute(int x,int y){
        if (x == 1 || y == 1){
            return 1;
        }
        return compute(x - 1,y) + compute(x,y - 1);
    }
    //超时
    public void dfs(int x,int y,int m,int n){
        if(x >= m || y >= n){
            return;
        }
        else if(x == m - 1 && y == n - 1){
            count ++;
        }
        else{
            dfs(x + 1,y,m,n);
            dfs(x,y + 1,m,n);
        }
    }

    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        int i = paths.uniquePaths(4, 6);
        System.out.println(i);
    }
}
