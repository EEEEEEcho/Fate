package com.micosoft;

import java.util.*;

public class Main2 {
    public int solution(int[] V, int[] A, int[] B) {
        // write your code in Java SE 8
        //打个表
        boolean[][] graph = new boolean[V.length][V.length];
        for (int i = 0; i < A.length; i++) {
            graph[B[i]][A[i]] = true;
        }
        LinkedList<Node> list = new LinkedList<>();
        for (int i = 0; i < V.length; i++) {
            list.add(new Node(V[i],i));
        }
        int max = 0;
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            Node m = list.get(i);
            Node n = list.get(i + 1);
            boolean flg = false;
            if (graph[m.value][n.value]){
                for (int j = 0; j < graph[n.value].length; j++) {
                    if (graph[n.value][j]){
                        flg = true;
                        break;
                    }
                }
                if (!flg){
                    max = Math.max(max,m.index + n.index);
                }

            }
        }
        return max;
    }
    class Node{
        int index;
        int value;
        public Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        treeMap.put(1,2);
        treeMap.put(2,1);
        System.out.println(treeMap);
    }
}
