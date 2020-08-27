package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBiTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            arrayList.add(tmp.val);
            if(tmp.left != null){
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                queue.add(tmp.right);
            }
        }
        return arrayList;
    }
}
