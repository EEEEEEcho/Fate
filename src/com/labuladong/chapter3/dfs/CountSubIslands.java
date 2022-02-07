package com.labuladong.chapter3.dfs;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //主要思路还是淹。。淹掉那些在grid1中是0，但是在grid2中是1的岛屿，这肯定不是子岛
        int ans = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2,i,j);
                }
            }
        }
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1){
                    ans++;
                    dfs(grid2,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int i,int j){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return;
        }
        if (grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid,i - 1,j);
        dfs(grid,i + 1,j);
        dfs(grid,i,j - 1);
        dfs(grid,i,j + 1);
    }
}
