package com.code.carl.tree.build;

import com.code.carl.tree.TreeNode;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length - 1);
    }
    public TreeNode build(int[] nums,int left,int right){
        if (left > right) return null;
        int max = nums[left];
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums,left,index - 1);
        root.right = build(nums,index + 1,right);
        return root;
    }
}
