package com.code.carl.tree.check;

import com.code.carl.tree.TreeNode;

public class IsBalanced {
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1;
//    }
//    public int getHeight(TreeNode node){
//        if (node == null) return 0;
//        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
//    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node){
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        else{
            return 1 + Math.max(leftHeight,rightHeight);
        }
    }
}
