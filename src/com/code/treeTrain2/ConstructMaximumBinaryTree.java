package com.code.treeTrain2;

import com.code.TreeTrain.TreeNode;

public class ConstructMaximumBinaryTree {
    //对于构造二叉树的问题，根节点要做的就是把想办法把自己构造出来。
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length - 1);
    }

    private TreeNode construct(int[] nums,int m,int n){
        //注意边界条件，不能是>=。因为在=的时候也可以构造一个节点，构造一层。
        if(m > n){
            return null;
        }
        int maxIndex = getMaxIndex(nums, m, n);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums,m,maxIndex - 1);
        root.right = construct(nums,maxIndex + 1,n);
        return root;
    }

    private int getMaxIndex(int[] nums,int i,int j){
        int max = nums[i];
        int maxIndex = i;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max){
                max = nums[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
