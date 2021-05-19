package com.leetCode.TreeTrain;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        midOrder(root);
        for (Integer val : list){
            if((k - val != val) && list.contains(k - val)){
                return true;
            }
        }
        return false;
    }
    public void midOrder(TreeNode node){
        if(node == null){
            return;
        }
        midOrder(node.left);
        list.add(node.val);
        midOrder(node.right);
    }
}
