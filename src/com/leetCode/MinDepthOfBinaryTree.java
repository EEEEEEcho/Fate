package com.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */
public class MinDepthOfBinaryTree {
    /**
     * 求最大高度的方法
     * @param root
     * @return
     */
    public int runMax(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = runMax(root.left);
        int right = runMax(root.right);
        return Math.min(left , right) + 1;
    }

    /**
     *
     * @param root
     * @return
     */
    public int run(TreeNode root){
        //根是空值
        if(root == null){
            return 0;
        }
        //该节点为叶子节点
        if(root.left == null && root.right == null){
            return 1;
        }
        //该节点只有一个孩子，当前节点高度（只看当前节点）为1+ 那个不为null的子树的高度，因此为max
        if(root.left == null || root.right == null){
            return 1 + Math.max(run(root.left),run(root.right));
        }
        //最后左右都不为空
        return 1 + Math.min(run(root.left),run(root.right));
    }

    /**
     * 层次遍历，比较好理解。，只要找到第一个叶子节点所在的层  就是结果
     * @param root
     * @return
     */
    public int run1(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i < size;i ++){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    return 1 + depth;
                }
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            depth ++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinDepthOfBinaryTree m = new MinDepthOfBinaryTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.left = t3;
        t1.right = t4;
//        m.run(t1);
        System.out.println(m.run(t1));
    }
}
