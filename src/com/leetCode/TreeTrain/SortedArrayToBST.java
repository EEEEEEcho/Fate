package com.leetCode.TreeTrain;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bfs(nums,0,nums.length - 1);
    }
    public TreeNode bfs(int[] nums,int low,int high){
        if(low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bfs(nums,low,mid-1);
        root.right = bfs(nums,mid + 1,high);
        return root;
    }
}
