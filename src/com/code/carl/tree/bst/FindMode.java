package com.code.carl.tree.bst;

import com.code.carl.tree.TreeNode;

import java.util.*;

public class FindMode {
//    private HashMap<Integer,Integer> map = new HashMap<>();
//    public int[] findMode(TreeNode root) {
//        inOrder(root);
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        if (entries.size() == 0) return new int[0];
//        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(entries);
//        list.sort((e1,e2) ->
//            Integer.compare(e2.getValue(),e1.getValue()));
//
//        Map.Entry<Integer, Integer> entry = list.get(0);
//        Integer max = entry.getValue();
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (Map.Entry<Integer,Integer> entry1 : list){
//            if (entry1.getValue().equals(max)){
//                ans.add(entry1.getKey());
//            }
//        }
//        int[] arr = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++) {
//            arr[i] = ans.get(i);
//        }
//        return arr;
//    }
//    public void inOrder(TreeNode node){
//        if (node == null) return;
//        inOrder(node.left);
//        map.put(node.val,map.getOrDefault(node.val,0) + 1);
//        inOrder(node.right);
//    }
    //当前频率
    private int count;
    //最大频率
    private int maxCount;
    //前一个节点
    private TreeNode pre;
    //结果集
    private ArrayList<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);
        if (pre == null){
            count = 1;  //第一个节点
        }
        else if(pre.val == node.val){
            count ++;   //前一个节点等于当前节点，计数加一
        }
        else {
            count = 1;  //不相等了
        }
        //向前走一步
        pre = node;

        if (count == maxCount){
            list.add(node.val);
        }
        if (count > maxCount){
            //如果当前计数大于最大计数，那么更新最大计数。
            maxCount = count;
            list.clear();
            //重新添加到列表中
            list.add(node.val);
        }
        inOrder(node.right);
    }
}
