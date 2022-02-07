package com.labuladong.chapter3.dfs;

import java.util.HashMap;

public class NumIslands {
    //FloodFill算法，找到岛屿，DFS将岛屿淹掉
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i - 1,j);  //上
        dfs(grid,i + 1,j);  //下
        dfs(grid,i,j - 1);  //左
        dfs(grid,i,j + 1);  //右

    }
}
