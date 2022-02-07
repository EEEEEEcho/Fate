package com.theswordreferstooffer.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 */
public class FindNumsAppearOnce {
    /**书上的方法:两个相同的数异或后为 0，一个数和 0 异或还是它本身，
     * 将所有数异或后即 得到 A、B 异或的结果，然后求得 1 在该数最右边出现的 index，
     * 然后判断每个数 右移 index 后是不是 1
     * 看不懂
     *  */
    public void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if(array == null){
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        for(int i=1;i < array.length;i ++){
            //异或，相同为0，相异为1
            number = number ^ array[i];
        }
        //异或后的数1出现在第几位
        int index = 0;
        while ((number & 1) == 0){
            number = number >> 1;
            index ++;
        }
        for(int i=0;i < array.length;i ++){
            boolean isBit = ((array[i] >> index) & 1) == 0;
            if(isBit){
                num1[0] ^= array[i];
            }
            else{
                num2[0] ^= array[i];
            }
        }
    }
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 0 || array == null){
            return;
        }
        Arrays.sort(array);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i < array.length;i ++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }
            else{
                hashMap.put(array[i],hashMap.get(array[i]) + 1);
            }
        }
        boolean flg = true;
        for(Map.Entry entry : hashMap.entrySet()){
            if((Integer)entry.getValue() == 1){
                if(flg){
                    num1[0] = (Integer)entry.getKey();
                    flg = false;
                }
                else{
                    num2[0] = (Integer)entry.getKey();
                }
            }
        }
    }

    public static void main(String[] args) {
//        FindNumsAppearOnce f = new FindNumsAppearOnce();
//        int array[] = new int[]{4,6,1,1,1,1};
//        int num1[] = new int[1];
//        int num2[] = new int[1];
//        f.findNumsAppearOnce(array,num1,num2);
        System.out.println(5 & 1);
    }
}
