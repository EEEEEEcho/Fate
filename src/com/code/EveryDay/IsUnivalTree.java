package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                if (pre != null && pre.val != root.val) return false;
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
