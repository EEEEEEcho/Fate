package com.labuladong.chapter3.dfs;

public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length - 1);
        }
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid,0,j);
            dfs(grid,grid.length - 1,j);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    count += dfs2(grid,i,j);
                }
            }
        }
        return count;
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
    public Integer dfs2(int[][] grid,int i,int j){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        else {
            grid[i][j] = 0;
            return 1 + dfs2(grid,i - 1,j) + dfs2(grid,i + 1,j) + dfs2(grid,i,j - 1) + dfs2(grid,i,j + 1);
        }
    }
}
