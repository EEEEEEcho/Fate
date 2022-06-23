package com.code.EveryDay;

public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        //共有m + n - 1条对角线
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1){
                //奇数从上往下遍历
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >=0 ){
                    ans[index ++] = mat[x ++][y --];
                }
            }
            else{
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n){
                    ans[index ++] = mat[x --][y ++];
                }
            }
        }
        return ans;
    }
}
