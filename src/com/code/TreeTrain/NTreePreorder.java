package com.code.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorder {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        preOrder(root);
        return list;
    }
    public void preOrder(Node node){
        if (node == null){
            return;
        }
        List<Node> children = node.children;
        if (children.size() > 0){
            list.add(node.val);
            for (Node child : children){
                preorder(child);
            }
        }
        else{
            list.add(node.val);
        }
    }
}
