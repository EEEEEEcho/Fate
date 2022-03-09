package com.code.topOnehundred;

import java.util.Arrays;
import java.util.HashSet;

public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind2 unionFind2 = new UnionFind2(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1){
                    unionFind2.union(i,j);
                }
            }
        }
        int[] parent = unionFind2.getParent();
        //注意，这里是省份的数量，单独的一个城市并不算省份
//        System.out.println(Arrays.toString(parent));
        int circles = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public static void main(String[] args) {
        FindCircleNum f = new FindCircleNum();
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        f.findCircleNum(new int[][]{
                {1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}
        });
    }
}
class UnionFind2{
    private int[] parent;
    public UnionFind2(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            parent[rootX] = rootY;
        }
    }
    public int[] getParent(){
        return parent;
    }
}