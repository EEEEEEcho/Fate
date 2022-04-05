package com.code.carl.tree.depth;

import com.code.carl.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinDepth {
    //后序遍历
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //这里可能会出现左子树全空，或者右子树全空的情况。
        //如果左子树全空，那么最小高度应该是右子树的高度 + 1
        if (left == 0) return right + 1;
        //如果右子树全空，那么最小高度应该是左子树的高度 + 1
        if (right == 0) return left + 1;
        //如果两个子树非全空，那么最小高度应该是两者最小高度 + 1
        return Math.min(left,right) + 1;
    }

    //迭代遍历
    //遇到某个结点左右孩子都为空的时候，就证明到了最低高度
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
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
