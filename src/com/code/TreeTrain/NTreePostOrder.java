package com.code.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class NTreePostOrder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        post(root);
        return list;
    }
    public void post(Node node){
        if(node == null){
            return;
        }
        List<Node> children = node.children;
        if(children.size() > 0){
            for(Node child : children){
                post(child);
            }
            list.add(node.val);
        }
        else{
            list.add(node.val);
        }
    }
}
