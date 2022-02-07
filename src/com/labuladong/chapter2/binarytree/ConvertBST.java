package com.labuladong.chapter2.binarytree;

public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convertOrder(root);
        return root;
    }
    public void convertOrder(TreeNode treeNode){
        if (treeNode == null) return;
        convertOrder(treeNode.right);
        treeNode.val = treeNode.val + sum;
        sum = treeNode.val;
        convertOrder(treeNode.left);
    }
}
