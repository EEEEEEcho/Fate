package com.code.TreeTrain;

public class IsBalance {
//    public boolean isBalanced(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        //前序遍历，根左右
//        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//    public int height(TreeNode treeNode){
//        if(treeNode == null){
//            return 0;
//        }
//        return Math.max(height(treeNode.left),height(treeNode.right)) + 1;
//    }
    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //后续遍历，左右根
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
