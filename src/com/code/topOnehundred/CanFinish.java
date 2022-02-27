package com.code.topOnehundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinish {
    //邻接矩阵 + 拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        //顶点入度数，入读为0的顶点可以作为起点
        int[] inDegree = new int[numCourses];
        //边数
        int edges = 0;
        //初始化入读数
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] > 0){
                    //从顶点i到顶点j有边，那么顶点j的入度数 + 1
                    inDegree[j] ++;
                    edges ++;
                }
            }
        }
        //可以作为起点的节点集合,即入度为0的点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        //没有起点。肯定是一个大环
        if (queue.size() == 0){
            return false;
        }
        while (!queue.isEmpty()){
            //当前遍历的起点
            int cur = queue.poll();
            for (int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] > 0){
                    //从当前节点到节点i有边，删除该边，节点i的入读减一
                    edges --;
                    inDegree[i] --;
                    //如果这个节点的入度成了0，那么它就成为了一个新的起点，加入起点队列
                    if (inDegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return edges == 0;
    }

    List<List<Integer>> graph;
    int[] visited;
    //邻接表 + 深度优先搜索
    //三个状态位
    //i == 0 ： 干净的，未被 DFS 访问
    //i == -1：其他节点启动的 DFS 访问过了，路径没问题，不需要再访问了
    //i == 1  ：本节点启动的 DFS 访问过了，一旦遇到了也说明有环了
    public boolean canFinish1(int numCourses, int[][] prerequisites){
        //构造邻接表和标记数组
        graph = new ArrayList<>();
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] courseMap : prerequisites){
            graph.get(courseMap[1]).add(courseMap[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph,visited,i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph,int[] visited,int i){
        if (visited[i] == 1) return false;  //在本轮dfs中遇到已经标记过的点，返回false
        if (visited[i] == -1) return true;  //遇到的点在别的dfs中已经走过，且证明没问题返回true
        visited[i] = 1; //标记该节点为本轮遍历过
        for (Integer adjNode : graph.get(i)){
            //以该节点为起始，继续dfs
            if (!dfs(graph,visited,adjNode)) return false;
        }
        //如果以该节点的dfs结束，证明以该节点为起点的dfs路径不包含环，标记为可信
        visited[i] = -1;
        return true;
    }

}
