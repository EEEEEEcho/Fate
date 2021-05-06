package com.leetCode.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {
//    List<Integer> result = new ArrayList<>();
//    public int getMinimumDifference(TreeNode root) {
//        int minDifference = Integer.MAX_VALUE;
//        midOrder(root);
//        for(int i = 0;i < result.size() - 1;i ++){
//            int abs = Math.abs(result.get(i) - result.get(i + 1));
//            if( abs < minDifference){
//                minDifference = abs;
//            }
//        }
//        return minDifference;
//    }
//    public void midOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        midOrder(root.left);
//        result.add(root.val);
//        midOrder(root.right);
//    }
    int diff = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        midOrder(root);
        return diff;
    }
    private void midOrder(TreeNode node){
        if(node == null){
            return;
        }
        midOrder(node.left);
        //如果是开始的根节点，将pre的值赋值为根节点的值，然后什么也不操作
        if(pre == -1){
            pre = node.val;
        }
        else{
            diff = Math.min(diff,Math.abs(pre - node.val));
            pre = node.val;
        }
        midOrder(node.right);
    }
}
