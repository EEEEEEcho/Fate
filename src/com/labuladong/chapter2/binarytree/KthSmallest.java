package com.labuladong.chapter2.binarytree;

import java.util.LinkedList;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int now = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                //中序代码
                now ++;
                if (now == k){
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }
    //非递归先序遍历
    public void preOrder(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                //先序代码
                System.out.println(node);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
