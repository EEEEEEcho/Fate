package com.code.carl.dp;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1.dp[i][j]表示走到i,j位置不同路径的总和
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //2.递推公式:dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //遇到障碍物时，障碍物所在的行和列，在障碍物之后的dp值都为0，证明走不到了
        //3.dp数组初始化
        //有障碍的话，其实就是标记对应的dp table（dp数组）保持初始值(0)就可以了。
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }
            else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0){
                dp[0][j] = 1;
            }
            else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //只有当前格子没有障碍的时候才推导，有障碍的时候不推导，dp[i][j]为0，即当前有障碍物的话是没有办法走的
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
