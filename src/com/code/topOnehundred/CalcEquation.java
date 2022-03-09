package com.code.topOnehundred;

import java.util.*;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //进行初始化，为了方便表示，将字符串映射成整数。例如："a" -> 1 "b" -> 2
        int n = equations.size();
        //因为每个表达式都有两个字母
        UnionFind unionFind = new UnionFind(n * 2);
        HashMap<String ,Integer> hashMap = new HashMap<>();
        int id = 0; //整数映射
        for (int i = 0; i < n; i++) {
            List<String> list = equations.get(i);
            String s1 = list.get(0);
            String s2 = list.get(1);
            if(!hashMap.containsKey(s1)){
                hashMap.put(s1,id ++);
            }
            if (!hashMap.containsKey(s2)){
                hashMap.put(s2,id ++);
            }
            //将两个结点连接起来
            unionFind.union(hashMap.get(s1),hashMap.get(s2),values[i]);
        }
        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries){
            String s1 = query.get(0);
            String s2 = query.get(1);
            Integer key1 = hashMap.get(s1);
            Integer key2 = hashMap.get(s2);
            if (key1 == null || key2 == null){
                ans[i ++] = -1;
            }
            else{
                ans[i ++] = unionFind.isConnect(key1,key2);
            }
        }
        return ans;
    }
}
class UnionFind{
    //parent[i] 代表i结点的祖先节点是谁
    private int[] parent;
    //weight[i]代表i节点指向其祖先节点的权重
    private double[] weight;
    //例如 a / b = 2  -> parent[a] = b  weight[a] = 2
    public UnionFind(int n){
        parent = new int[n];
        weight = new double[n];
        //对所有节点初始化，每个节点在没有连同前，其祖先节点都是它自己
        //其指向祖先节点的权重都是1
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }
    public int find(int x){
        //找到x节点的祖先节点
        if(x != parent[x]){
            //如果它不等于它爸
            int origin = parent[x];
            //搜索并路径压缩,将路径压缩至x的祖先节点
            parent[x] = find(parent[x]);
            weight[x] *= weight[origin];
        }
        return parent[x];
    }
    public void union(int x,int y,double value){
        //将两个结点x,y进行连接
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return; //如果他俩有公共的祖先，那么直接返回，不用连接
        //否则将x的祖先设置成y的祖先进行连接
        parent[rootX] = rootY;
        weight[rootX] = weight[y] * value / weight[x];
    }
    public double isConnect(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        //如果两个节点的根节点相同，就证明二者是连接的
        if (rootX == rootY){
            return weight[x] / weight[y];
        }
        else{
            return  -1d;
        }
    }
}