package com.labuladong.chapter3.dfs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    ans = dfs(grid,i,j);
                    max = Math.max(ans,max);
                }
            }
        }
        return max;
    }

    public Integer dfs(int[][] grid,int i,int j){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        else {
            grid[i][j] = 0;
            return 1 + dfs(grid,i - 1,j) + dfs(grid,i + 1,j) + dfs(grid,i,j - 1) + dfs(grid,i,j + 1);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        m.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        });
    }
}
