package com.labuladong.chapter2.binarytree;

public class IsValidBST {
//    方式一
//    public boolean isValidBST(TreeNode root) {
//        return judgeBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//    public boolean judgeBST(TreeNode root,long lower,long upper){
//        if (root == null){
//            return true;
//        }
//        if(root.val <= lower || root.val >= upper){
//            return false;
//        }
//        return judgeBST(root.left,lower,root.val) && judgeBST(root.right,root.val,upper);
//    }
    public boolean isValidBST(TreeNode root) {
        return judgeBST(root,null,null);
    }
    public boolean judgeBST(TreeNode root,TreeNode min,TreeNode max){
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return judgeBST(root.left,min,root) && judgeBST(root.right,root,max);
    }
}
