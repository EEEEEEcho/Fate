package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Collections;

public class QuanPaiLie {
    private ArrayList<String> arrayList = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char arr[] = str.toCharArray();
        allSort(arr,0,arr.length - 1);
        //排序，按字典序输出
        Collections.sort(arrayList);
        return arrayList;
    }
    public void allSort(char arr[],int start,int end){
        if(start == end){
            String s = "";
            for(char c : arr){
                s += c;
            }
            arrayList.add(s);
        }
        for(int i=start; i<=end; i++){
            if(i == start || arr[i] != arr[start]){ //这句判断用来去重，去除相邻元素相同的话又排列一次的情况。例如aa, 输出aa 而不是aa , aa
                swap(arr,i,start);
                allSort(arr,start + 1,end);
                swap(arr,i,start);
            }
        }
    }
    public void swap(char arr[],int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void swapInt(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void allSortInt(int array[],int start,int end){
        //start = end 时证明找到了一个全排列，就可以输出了
        if(start == end){
            for(int i=0;i <= end;i ++){
                System.out.print(array[i]);
            }
            System.out.println();
        }
        for(int i= start;i <= end;i ++){
            if(i == start || array[i] != array[start]){
                swapInt(array,i,start);
                allSortInt(array,start + 1,end);
                swapInt(array,i,start);
            }
        }
    }
    public static void main(String[] args) {
        QuanPaiLie q = new QuanPaiLie();
        String s = "aa";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = q.Permutation(s);
        System.out.println(arrayList);
        int array[] = new int[]{1,2,3,4};
        q.allSortInt(array,0,array.length - 1);
    }
}
