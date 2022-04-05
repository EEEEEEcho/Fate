package com.code.carl.tree.check;

import com.code.carl.tree.TreeNode;

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean sameWithRoot = isSame(root,subRoot);
        boolean isLeftSubTree = isSubtree(root.left,subRoot);
        boolean isRightSubTree = isSubtree(root.right,subRoot);
        return sameWithRoot || isLeftSubTree || isRightSubTree;
    }
    public boolean isSame(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        else if(node1 == null && node2 != null){
            return false;
        }
        else if(node1 != null && node2 == null){
            return false;
        }
        else if(node1 != null && node2 != null && node2.val != node1.val){
            return false;
        }
        return isSame(node1.left,node2.left) && isSame(node1.right,node2.right);
    }
}
