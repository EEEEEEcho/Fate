package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTrivalBinaryTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null){
            return arrayLists;
        }
        queue.add(pRoot);
        while (! queue.isEmpty()){
            int level = queue.size();
            int cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (cnt < level){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
                cnt ++;
            }
            arrayLists.add(list);
        }
        return arrayLists;
    }
}
