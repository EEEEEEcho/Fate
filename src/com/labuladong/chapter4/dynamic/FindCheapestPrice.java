package com.labuladong.chapter4.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindCheapestPrice {
    //一个记录了点的入度的表。其中，键为顶点，值为一个int数组，数组的第一个元素是指向键顶点的一个点，边是权重
    //举个例子： 0 -> 1 权重为3
    //{1 : [0,3]}
    HashMap<Integer, List<int[]>> indegrees;
    int src;
    int dest;
    int memo[][];
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //将中转站个数转换为边数
        k ++;
        //初始化
        indegrees = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            indegrees.putIfAbsent(to,new ArrayList<>());
            indegrees.get(to).add(new int[]{from,price});
        }
        this.src = src;
        this.dest = dst;
        memo = new int[n][k + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-972);
        }
        return dp(dest,k);
    }
    //dp函数的定义，从src出发，k步之内到达 s 的最短路径权重。
    private int dp(int s,int k){
        if (s == this.src){
            return 0;
        }
        if (k == 0){
            return -1;
        }
        if (memo[s][k] != -972){
            return memo[s][k];
        }
        int res = Integer.MAX_VALUE;
        //如果入度列表中包含s
        if (indegrees.containsKey(s)){
            for (int[] arr : indegrees.get(s)){
                int from = arr[0];
                int price = arr[1];
                int subProblem = dp(from,k - 1);
                //跳过无解的情况
                if (subProblem != -1){
                    res = Math.min(res,subProblem + price);
                }
            }
        }
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}
