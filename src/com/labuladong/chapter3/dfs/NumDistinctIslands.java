package com.labuladong.chapter3.dfs;

import java.util.HashSet;

public class NumDistinctIslands {

    public int numDistinctIslands(int[][] grid){
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb,Integer.MAX_VALUE); //初始方向无所谓
                    //回溯完成，一个序列化结果就构造好了
                    hashSet.add(sb.toString());
                }
            }
        }
        return hashSet.size();
    }
    //序列化岛屿
    public void dfs(int[][] grid,int i,int j,StringBuilder sb,int dir){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return;
        }
        if (grid[i][j] == 0){
            return;
        }
        sb.append(dir).append(",");
        dfs(grid,i + 1,j,sb,1); //上 用数字 1 记录，撤销上用数字 -1 记录
        dfs(grid,i - 1,j,sb,2); //下 同理
        dfs(grid,i,j - 1,sb,3); //左
        dfs(grid,i,j + 1,sb,4); //右
        //前序遍历之后，回溯撤销
        sb.append(-dir).append(",");
    }
}
