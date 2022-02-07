package com.theswordreferstooffer.offer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 本质是归并排序，在比较时加入全局变量 count 进行记录逆序对的个数，
 * 若 data[start] >= data[index] ，则 count 值为 mid+1-start
 */
public class InversePairs {
    public static final int mod = 1000000007;
    int count = 0;
    public int inversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        mergeSort(array,0,array.length - 1);
        return count;
    }
    private void mergeSort(int array[],int start,int end){
        int mid = (start + end) / 2;
        if(start < end){
            mergeSort(array,start,mid);
            mergeSort(array,mid + 1,end);
            merge(array,start,mid,end);
        }
    }
    private void merge(int array[],int start,int mid,int end){
        int[] tmp = new int[end - start + 1];
        int c = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end){
            if(array[left] <= array[right]){
                tmp[c++] = array[left ++];
            }
            else{
                tmp[c++] = array[right ++];
                count += mid +1 - left;     //如果出现了一个左边数组中的数比右边的大的，
                count %= mod;
            }
        }
        while (left <= mid){
            tmp[c ++] = array[left ++];
        }
        while (right <= end){
            tmp[c ++] = array[right ++];
        }
        for(int i : tmp){
            array[start ++] = i;
        }
    }


    public static void main(String[] args) {

    }
}
