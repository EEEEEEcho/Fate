package com.leetCode.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    List<Integer> result;
    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        postOrder(root);
        return result;
    }
    public void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        result.add(node.val);
    }
}
