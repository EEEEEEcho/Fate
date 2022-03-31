package com.code.carl.tree.levelorder;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) return level;
            }
            level ++;
        }
        return level;
    }
}
