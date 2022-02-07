package com.code.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        preOrderTravel(root);
        return result;
    }
    public void preOrderTravel(TreeNode node){
        if (node == null){
            return;
        }
        result.add(node.val);
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }
}
