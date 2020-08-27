package com.theswordreferstooffer.offer;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数 字。如果不存在则输出 0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        Arrays.sort(array);
        for(int i=0;i < array.length;i ++){
            System.out.print(array[i]+" ");
        }
        int count = 1;
        for(int i=0;i < array.length - 2;i ++){
            if(array[i + 1] == array[i]){
                count ++;
                System.out.println(count);
                if(count > array.length / 2){
                    return array[i];
                }
            }
            else{
                count = 1;
            }
        }
        return 0;
    }

    /**
     * 书中方法
     * 将首次出现的数 count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一半
     * 遍历比较。。两重循环。
     * 还不如我的 排序一次
     * @param nums
     * @return
     */
    public static int moreThanHalfNum(int[] nums){
        int count = 0;
        int candidate = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return checkMoreThanHalf(nums,candidate) ? candidate : 0;
    }

    private static boolean checkMoreThanHalf(int[] array,Integer number){
        int times = 0;
        for(int i: array){
            if(i == number){
                times ++;
            }
        }
        return times * 2 >= array.length;
    }


    public static void main(String[] args) {
        MoreThanHalfNum m = new MoreThanHalfNum();
        int array[] = new int[]{1,2,3,2,2,2,5,4,2};
        int re = m.MoreThanHalfNum_Solution(array);
        System.out.println();
        System.out.println(re);
    }
}
