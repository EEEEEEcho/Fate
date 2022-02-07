package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }
    public void reverse(TreeNode node){
        if (node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        reverse(node.left);
        reverse(node.right);
    }
}
