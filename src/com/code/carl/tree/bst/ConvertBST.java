package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    public void inorder(TreeNode node){
        if (node == null) return ;
        inorder(node.right);
        node.val = node.val + sum;
        sum = node.val;
        inorder(node.left);
    }

    public TreeNode convertBST1(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            else{
                cur = stack.pop();
                cur.val += sum;
                sum = cur.val;
                cur = cur.left;
            }
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            else{
                cur = stack.pop();
                if (pre != null){
                    cur.val += pre.val;
                }
                else{
                    pre = new TreeNode(0);
                }
                pre.val = cur.val;
                cur = cur.left;
            }
        }
        return root;
    }
}
