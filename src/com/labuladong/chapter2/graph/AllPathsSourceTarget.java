package com.labuladong.chapter2.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        ArrayDeque<Integer> arrayDeque = new ArrayDeque();
//        arrayDeque.add(0);
//        for (int i = 0; i < graph[0].length; i++) {
//            dfs(graph,arrayDeque,graph[0][i],graph[0].length);
//        }
        dfs(graph,new ArrayDeque<>(),0,graph.length - 1);
        return ans;
    }
    public void dfs(int[][] graph, ArrayDeque<Integer> list, int row, int target){
        if (row == target){
            list.add(row);
            ans.add(new ArrayList<>(list));
            return;
        }
        else{
            list.add(row);
            for (int i = 0;i < graph[row].length;i ++){
                dfs(graph, list, graph[row][i], target);
                list.removeLast();
            }
        }
//        list.add(row);
//        for (int i = 0; i < graph[row].length; i++) {
//            if (graph[row][i] == target){
//                list.add(target);
//                ans.add(new ArrayList<>(list));
//                return;
//            }
//            dfs(graph,list,graph[row][i],target);
////            list.removeLast();
//        }
//        list.removeLast();
    }

    public static void main(String[] args) {
        AllPathsSourceTarget a = new AllPathsSourceTarget();
        a.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }
}
