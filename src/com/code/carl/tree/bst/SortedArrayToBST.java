package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }
    public TreeNode buildTree(int[] nums,int left,int right){
        if (left <= right){
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums,left,mid - 1);
            root.right = buildTree(nums,mid + 1,right);
            return root;
        }
        return null;
    }
}
