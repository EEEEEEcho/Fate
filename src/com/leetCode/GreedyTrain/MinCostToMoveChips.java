package com.leetCode.GreedyTrain;

import java.util.*;

public class MinCostToMoveChips {
//    public int minCostToMoveChips(int[] position) {
//        /**
//         * 很傻逼的想法
//         */
//        Map<Integer,Integer> treeMap = new HashMap<>();
//        for(Integer integer:position){
//            treeMap.putIfAbsent(integer, 0);
//            treeMap.put(integer,treeMap.get(integer) + 1);
//        }
//        ArrayList<Map.Entry<Integer,Integer>> list_hash = new ArrayList<>(treeMap.entrySet());
//        //System.out.println(treeMap);
//        System.out.println(list_hash);
//        Collections.sort(list_hash, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if(o1.getKey() < o2.getKey() && o1.getValue() < o2.getValue()){
//                    //System.out.println(o1.getKey() + " " + o2.getKey() + " " + o1.getValue() + " " + o2.getValue());
//                    return -1;
//                }
//                if(o1.getKey() < o2.getKey() && o1.getValue().equals(o2.getValue())){
//                    System.out.println(o1.getKey() + " " + o2.getKey() + " " + o1.getValue() + " " + o2.getValue());
//                    return -1;
//                }
//                if(o1.getValue().equals(o2.getValue()) && o1.getKey().equals(o2.getKey())){
//                    //System.out.println(o1.getKey() + " " + o2.getKey() + " " + o1.getValue() + " " + o2.getValue());
//                    return 0;
//                }
//                System.out.println(o1.getKey() + " " + o2.getKey() + " " + o1.getValue() + " " + o2.getValue());
//                System.out.println(o1.getKey() < o2.getKey());
//                System.out.println(o1.getValue() < o2.getValue());
//                return 1;
//            }
//        });
//        System.out.println(treeMap);
//        System.out.println(list_hash);
//        System.out.println(list_hash.get(0).getKey());
//
//        Integer key = list_hash.get(0).getKey();
//        //System.out.println(key);
//        int count = 0;
//        for(Map.Entry entry : treeMap.entrySet()){
//            int k = (int) entry.getKey();
//            if(k != key && Math.abs(key - k) % 2 != 0){
//                count += (int) entry.getValue();
//            }
//        }
//        return count;
//    }
    public int minCostToMoveChips(int[] position){
        /**
         * 因为移动2个位置不需要代价，那么奇数位置移到奇数位置不用代价，
         * 偶数位置移到偶数位置不用代价，那就分别统计奇数位置和偶数位置的个数
         * ，相当于把所有奇数放一起，所有偶数的放一起，然后比较奇数的少还是偶数的少，
         * 将少的个数移到多的个数位置上去就可以了。
         *
         */
        int even = 0;
        int odd = 0;
        for(int i = 0;i < position.length;i ++){
            if(position[i] % 2 == 0){
                even ++;
            }
            else{
                odd ++;
            }
        }
        return Math.min(even,odd);
    }
    public static void main(String[] args) {
        MinCostToMoveChips moveChips = new MinCostToMoveChips();
        System.out.println(moveChips.minCostToMoveChips(new int[]{2,2,2,3,3}));
    }
}
