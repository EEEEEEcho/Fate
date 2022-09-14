package com.code.EveryDay;

import com.code.carl.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1,list1);
        inOrder(root2,list2);
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()){
            if (list1.get(i) < list2.get(j)){
                result.add(list1.get(i ++));
            }
            else{
                result.add(list2.get(j ++));
            }
        }
        while (i < list1.size()){
            result.add(list1.get(i ++));
        }
        while (j < list2.size()){
            result.add(list2.get(j ++));
        }
        return result;
    }

    public void inOrder(TreeNode node,List<Integer> list){
        if(node == null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}
