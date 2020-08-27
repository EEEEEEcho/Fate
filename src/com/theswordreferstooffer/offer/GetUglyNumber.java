package com.theswordreferstooffer.offer;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int arr[] = new int[index];
        arr[0] = 1;
        int mul2 = 0;
        int mul3 = 0;
        int mul5 = 0;
        for(int i=1;i < index;i ++){
            int min = Math.min(arr[mul2] * 2,Math.min(arr[mul3] * 3,arr[mul5] * 5));
            arr[i] = min;
            if(arr[mul2] * 2 == min){
                mul2 ++;
            }
            if(arr[mul3] * 3 == min){
                mul3 ++;
            }
            if(arr[mul5] * 5 == min){
                mul5 ++;
            }
        }
        return arr[index - 1];
    }
}
