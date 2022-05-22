package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

import java.util.Arrays;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        searchBST(root,val);
        return root;
    }
    public TreeNode searchBST(TreeNode node,int value){
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if(node.val > value){
            node.left = searchBST(node.left,value);
        }
        if (node.val < value){
            node.right = searchBST(node.right,value);
        }
        return node;
    }
    //迭代法
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null){
            parent = cur;
            if (val < cur.val){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val < parent.val) parent.left = node;
        else parent.right = node;
        return root;
    }
}
