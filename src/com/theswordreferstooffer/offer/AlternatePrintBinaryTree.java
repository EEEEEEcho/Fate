package com.theswordreferstooffer.offer;


import java.util.*;

public class AlternatePrintBinaryTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int height = 0;
        ArrayList<Integer> list;
        while (! queue.isEmpty()){
            height ++;
            list = new ArrayList<>();
            int curSize = queue.size();
            int cnt = 0;
            while (cnt < curSize){
                TreeNode node = queue.poll();
                list.add(node.val);
                cnt ++;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(height % 2 == 0){
                ArrayList<Integer> tmp = new ArrayList<>();
                for(int i = list.size() - 1;i >=0;i --){
                    tmp.add(list.get(i));
                }
                arrayLists.add(tmp);
            }
            else{
                arrayLists.add(list);
            }
        }
        return arrayLists;
    }
}
