package com.labuladong.chapter3.dfs;

public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int res = 0;
        //把周围的陆地淹掉
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid,0,j);
            dfs(grid,grid.length - 1,j);
        }
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length - 1);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    private void dfs(int[][] grid,int i,int j){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return;
        }
        else{
            if (grid[i][j] == 1) return;
            grid[i][j] = 1;
            dfs(grid,i - 1,j);
            dfs(grid,i + 1,j);
            dfs(grid,i,j - 1);
            dfs(grid,i,j + 1);
        }
    }
}
