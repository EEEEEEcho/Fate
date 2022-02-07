package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class GetLeastNumbers {
    //我的解法。
//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Arrays.sort(input);
//        if(k > input.length){
//            return arrayList;
//        }
//        while (k > 0){
//            arrayList.add(input[k-1]);
//            k --;
//        }
//        return arrayList;
//    }
    //书中解法
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input,int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return arrayList;
        }
        int[] kArray = Arrays.copyOfRange(input,0,k);
        //建堆
        buildHeap(kArray);
        for(int i =k;i < input.length;i ++){
            if(input[i] < kArray[0]){
                kArray[0] = input[i];
                maxHeap(kArray,0);
            }
        }
        for(int i=kArray.length - 1;i >= 0;i --){
            arrayList.add(kArray[i]);
        }
        return arrayList;
    }
    //建堆操作，注意 是左右分别建
    public void buildHeap(int input[]){
        for(int i = input.length / 2 - 1;i >= 0;i --){
            maxHeap(input,i);
        }
    }
    private void maxHeap(int array[],int i){
        int left = 2 * i + 1;       //左孩子
        int right = left + 1;       //右孩子
        int largest = 0;
        //找出左右最大的
        if(left < array.length && array[left] > array[i]){
            largest = left;
        }
        else{
            largest = i;
        }
        if(right < array.length && array[right] > array[largest]){
            largest = right;
        }
        //调整大根堆 使其上浮
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array,largest);
        }
    }
}
