package com.labuladong.chapter2.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    //层次遍历。通过
    public Node connect1(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int num = queue.size();     //当前层的二叉树的节点个数
            ArrayList<Node> arrayList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Node node = queue.poll();
                arrayList.add(node);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            for (int i = 0;i < arrayList.size();i ++){
                if (i == arrayList.size() - 1){
                    arrayList.get(i).next = null;
                }
                else{
                    arrayList.get(i).next = arrayList.get(i + 1);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root){
        if (root == null) return null;
        connected(root.left,root.right);
        return root;
    }

    //辅助函数，用来连接结点
    public void connected(Node node1,Node node2){
        if (node1 == null || node2 == null){
            return;
        }
        //连接两个相邻的节点
        node1.next = node2;
        //连接父节点相同的两个节点
        connected(node1.left,node1.right);
        connected(node2.left,node2.right);
        //连接父节点不同的两个节点
        connected(node1.right,node2.left);
    }
}
