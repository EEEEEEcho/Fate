package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个整型数组，数组中有正数也有负数，
 * 数组中一个或连续的多 个整数组成一个子数组，求连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    //我的做法
    public int FindGreatestSumOfSubArray(int[] array) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int max;
        int sum;
        for(int i=0;i < array.length;i ++){
            max = array[i];
            sum = 0;
            for(int j=i;j < array.length;j ++){
                    sum += array[j];
                    if(sum > max){
                        max = sum;
                    }
            }
            //System.out.println(max);
            arrayList.add(max);
        }
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - 1);
    }
    //书中做法
    //若和小于 0，则将最大和置为当前值，否则计算最大和。
    public int FindGreatestSumOfSubArray1(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int sum = 0;
        int result = array[0];
        for(int num : array){
            sum = sum > 0 ? sum + num : num;
            result = Math.max(sum,result);
        }
        return result;
    }
    public static void main(String[] args) {
        FindGreatestSumOfSubArray f = new FindGreatestSumOfSubArray();
        int array[] = new int[]{1,-2,3,10,-4,7,2,-5};
        int r = f.FindGreatestSumOfSubArray(array);
        System.out.println(r);
    }
}
