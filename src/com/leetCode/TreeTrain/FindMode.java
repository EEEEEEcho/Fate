package com.leetCode.TreeTrain;

import java.util.*;

public class FindMode {
    //1.我自己的朴素算法
//    public int[] findMode(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        midOrder(root,result);
//        Collections.sort(result);
//        Map<Integer,Integer> map = new HashMap<>();
//        for(Integer num : result){
//            if(map.get(num) == null){
//                map.put(num,1);
//            }
//            else{
//                map.put(num,map.get(num) + 1);
//            }
//        }
//
//        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort(Map.Entry.comparingByValue());
//        int count = 1;
//        int tmp = entryList.get(entryList.size() - 1).getValue();
//        // System.out.println(tmp);
//        for(int i = entryList.size() - 2;i >= 0;i --){
//            if(entryList.get(i).getValue() == tmp){
//                count ++;
//            }
//        }
//        int[] resultArray = new int[count];
//        for(int i = 0;i < count;i ++){
//            resultArray[i] = entryList.get(entryList.size() - 1 -i).getKey();
//        }
//        return resultArray;
//    }
//    private void midOrder(TreeNode root, List<Integer> result){
//        if (root == null) return;
//        midOrder(root.left,result);
//        result.add(root.val);
//        midOrder(root.right,result);
//    }
    List<Integer> list = new ArrayList<>();
    int base;
    int count;
    int maxCount;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[list.size()];
        for (int i = 0; i < mode.length; i++) {
            mode[i] = list.get(i);
        }
        return mode;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    /**
     * 统计有序数组中的众数
     * @param value 数组中的某个元素
     */
    private void update(int value){
        if (value == base){
            ++count;
        }
        else{
            count = 1;
            base = value;
        }
        if(count == maxCount){
            list.add(value);
        }
        if(count > maxCount){
            maxCount = count;
            list.clear();
            list.add(value);
        }
    }
}
