package com.code.carl.tree.count;

import com.code.carl.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {
    public int findBottomLeftValue1(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0){
                    ans = node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
    int maxDepth;
    int maxLeftValue;
    public int findBottomLeftValue(TreeNode root) {
        goThrough(root,1);
        return maxLeftValue;
    }

    //先序遍历，一直向左
    //最左边的节点一定出现在最大深度上
    private void goThrough(TreeNode node,int leftDepth){
        //根
        if (node.left == null && node.right == null){
            if (leftDepth > maxDepth){
                maxDepth = leftDepth;
                maxLeftValue = node.val;
            }
        }
        //左
        if(node.left != null){
            leftDepth ++;
            goThrough(node.left,leftDepth);
            leftDepth --;
        }
        //右
        if(node.right != null){
            leftDepth ++;
            goThrough(node.right,leftDepth);
            leftDepth --;
        }
    }
}
