package com.code.carl.tree.check;

import com.code.carl.tree.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果两个节点都是null，那么两棵树相同
        if (p == null && q == null){
            return true;
        }
        else if (p == null && q != null){
            return false;
        }
        else if(p != null && q == null){
            return false;
        }
        else if(p != null && q != null && p.val != q.val){
            return false;
        }

        boolean leftSame = isSameTree(p.left,q.left);
        boolean rightSame = isSameTree(p.right,q.right);
        return leftSame && rightSame;
    }
}
