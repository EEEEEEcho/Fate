package com.code.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class AllCellsDistOrder {
    class Node implements Comparable<Node>{
        int dif;
        int markX;
        int markY;
        public Node(int dif,int markX,int markY){
            this.dif = dif;
            this.markX = markX;
            this.markY = markY;
        }
        @Override
        public int compareTo(Node node) {
            return this.dif - node.dif;
        }
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        ArrayList<Node> nodes = new ArrayList<>();
        for(int i=0;i < R;i ++){
            for (int j = 0;j < C;j ++){
                nodes.add(new Node((Math.abs(r0-i) + Math.abs(c0 - j)),i,j));
            }
        }
        Collections.sort(nodes);
        for(int i=0;i < result.length;i ++){
            result[i] = new int[]{nodes.get(i).markX,nodes.get(i).markY};
        }
        return result;
    }
}
