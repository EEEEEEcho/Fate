package com.qiye;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class CountTragnle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node index[] = new Node[n];
        for(int i=0;i < n;i ++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Node node = new Node(x,y);
            index[i] = node;
        }
        int count = 0;
        for(int i=0;i < index.length;i ++){
            for (int j = i+1;j < index.length;j ++){
                for (int k = j+1;k < index.length;k++){
                    if(isTriangle(index[i],index[j],index[k])){
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isTriangle(Node node1,Node node2,Node node3){
        int x1 = node1.x - node2.x;
        int y1 = node1.y - node2.y;
        int x2 = node2.x - node3.x;
        int y2 = node2.y - node3.y;
        int result = x1*y2 - x2*y1;
        if(result!= 0){
            return true;
        }
        return false;
    }
}
