package com.leetCode.TreeTrain;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
//    private void midOrder(TreeNode p, TreeNode q){
//        if(p != null && q != null){
//            midOrder(p.left,q.left);
//            flg = (p.val == q.val);
//            midOrder(p.right,q.right);
//        }
//        else{
//            flg = false;
//        }
//    }
}
