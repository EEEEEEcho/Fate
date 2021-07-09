package com.code.TreeTrain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public boolean findTarget2(TreeNode root, int k){
        Set<Integer> set = new HashSet<>();
        return find(root,k,set);
    }

    public boolean find(TreeNode node,int k,Set<Integer> set){
        if (node == null){
            return false;
        }
        if (set.contains(k - node.val)){
            return true;
        }
        set.add(node.val);
        //在左子树和右子树中查找，如果有一种满足情况的则满足
        return find(node.left,k,set) || find(node.right,k,set);
    }
}
