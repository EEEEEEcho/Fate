package com.labuladong.chapter2.binarytree;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }
    public TreeNode buildTree(int[] nums,int left,int right){
        if (left > right) return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i <= right ; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums,left,maxIndex - 1);
        root.right = buildTree(nums,maxIndex + 1 ,right);
        return root;
    }
}
