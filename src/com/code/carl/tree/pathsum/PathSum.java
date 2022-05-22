package com.code.carl.tree.pathsum;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return ans;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(root.val);
        targetSum -= root.val;
        dfs(root,targetSum,deque);
        return ans;
    }
    public void dfs(TreeNode node, int target, Deque<Integer> deque){
        if (node.left == null && node.right == null && target == 0){
            ans.add(new ArrayList<>(deque));
        }
        if (node.left == null && node.right == null){
            return;
        }
        if (node.left != null){
            target -= node.left.val;
            deque.add(node.left.val);
            dfs(node.left,target,deque);
            target += node.left.val;
            deque.removeLast();
        }
        if (node.right != null){
            target -= node.right.val;
            deque.add(node.right.val);
            dfs(node.right,target,deque);
            target += node.right.val;
            deque.removeLast();
        }
    }
}
