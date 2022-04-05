package com.code.EveryDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CountMaxOrSubsets {
    private List<List<Integer>> subsets = new ArrayList<>();
    public int countMaxOrSubsets(int[] nums) {
        backtrace(nums,0,new ArrayDeque<>());
        int max = -1;
        List<Integer> result = new ArrayList<>();
        for(List<Integer> list : subsets){
            if(list.size() > 0){
                int r = list.stream().reduce((num1,num2) -> num1 | num2).get();
                max = Math.max(max,r);
                result.add(r);
            }
        }
        int count = 0;
        for(int num : result){
            if(num == max){
                count ++;
            }
        }
        return count;
    }
    public void backtrace(int[] nums,int index,ArrayDeque<Integer> path){
        subsets.add(new ArrayList<>(path));
        for(int i = index;i < nums.length;i ++){
            path.add(nums[i]);
            backtrace(nums,i + 1,path);
            path.removeLast();
        }
    }
    //二进制枚举
    //记 n 是数组nums的长度，数组中的每个元素都可以选取或者不选取，因此数组的非空子集数目一共有 (2^n-1)个。
    //可以用一个长度为n比特的整数来表示不同的子集，在整数的二进制表示中，n个比特的值代表了对数组不同元素的取舍。
    // 第i位值为1则表示该子集选取对应元素，第i位值为0则表示该子集不选取对应元素。
    // 求出每个子集的按位或的值，并计算取到最大值时的子集个数。
    //比如说数组的长度为2，那么可以选取一个长度为2个bit的整数来表示不同的子集
    // 如：0 0。代表 两个元素都不选  0 1 代表选第1个不选第二个，1 0 代表选第2个不选第1个，1 1 代表两个都选
    // 这个n bit的数字的整数表示就是 2 ^ 2 - 1 = 3
    //就代表着对num[]
    public int countMaxOrSubsets2(int[] nums) {
        int n = nums.length;
        int bitNum = 1 << n;    //n个bit的整数
        int max = 0;
        int count = 0;
        for (int i = 0; i < bitNum; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if((i >> j & 1) == 1){
                    cur = cur | nums[j];
                }
            }
            if(cur > max){
                max = cur;
                count = 1;
            }
            else if(cur == max){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        CountMaxOrSubsets c = new CountMaxOrSubsets();
//        c.countMaxOrSubsets(new int[]{3,1});
        System.out.println(1 << 2);
    }
}
