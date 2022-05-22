package com.code.codertop;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.pop();
            ans.add(treeNode.val);
            if (treeNode.right != null){
                deque.push(treeNode.right);
            }
            if (treeNode.left != null){
                deque.push(treeNode.left);
            }
        }
        return ans;
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }
    public void preOrder(TreeNode node){
        if (node == null) return;
        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
