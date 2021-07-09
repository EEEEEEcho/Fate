package com.code.TreeTrain;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return bfs(root.left,root.right);
    }
    private boolean bfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return bfs(left.left,right.right) && bfs(left.right,right.left);
    }
}
