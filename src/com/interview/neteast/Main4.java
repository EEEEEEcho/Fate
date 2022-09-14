package com.interview.neteast;

import com.echo.A;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rootIndex = -1;
        LinkedHashMap<Integer,Node> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            if (i == 0){
                rootIndex = index;
            }
            map.put(index,new Node(index,new ArrayList<>()));
        }
        if (n == 1){
            System.out.println(getFactor(rootIndex));
            return;
        }
        scanner.nextLine();
        for (int i = 0; i < n - 1; i++) {
            String line = scanner.nextLine();
            String[] numsArr = line.split(" ");
            int parent = Integer.parseInt(numsArr[0]);
            int child = Integer.parseInt(numsArr[1]);
            Node parentNode = map.get(parent);
            Node childNode = map.get(child);
            parentNode.children.add(childNode);
        }
        Node root = map.get(rootIndex);
        buildMulti(root);
        buildWeight(root);
        System.out.println(root.weight);
    }
    public static int buildWeight(Node root){
        if (root.children.isEmpty()){
            root.weight = getFactor(root.mutil) % ((int) Math.pow(10,9) + 7);
            return root.weight;
        }
        root.weight = getFactor(root.mutil) % ((int) Math.pow(10,9) + 7);
        for (int i = 0;i < root.children.size();i ++){
            root.weight += buildWeight(root.children.get(i));
        }
        return root.weight;
    }

    public static int buildMulti(Node root){
        if (root.children.isEmpty()){
            root.mutil = root.index;
            return root.mutil;
        }
        for (int i = 0; i < root.children.size(); i++) {
            root.mutil *= buildMulti(root.children.get(i));
        }
        return root.mutil;
    }
    public static int getFactor(int n){
        int count = 1;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0){
                count ++;
            }
        }
        return count;
    }
}
class Node{
    int index;
    int mutil;
    int weight;
    List<Node> children;
    public Node(int index,List<Node> list){
        this.index = index;
        this.mutil = 1;
        this.children = list;
    }
}