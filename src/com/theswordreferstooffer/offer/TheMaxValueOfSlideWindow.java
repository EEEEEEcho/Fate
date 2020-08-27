package com.theswordreferstooffer.offer;

import java.util.ArrayList;

public class TheMaxValueOfSlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0||size == 0 ||size > num.length){
            return list;
        }
        for(int i=0; i <num.length - size + 1;i++){
            int max = Integer.MIN_VALUE;
            int count = 0;
            for(int j = i;count < size;count++,j ++){
                if(num[j] > max){
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args) {
        TheMaxValueOfSlideWindow t = new TheMaxValueOfSlideWindow();
        int nums[] = {2,3,4,2,6,2,5,1};
        int n = 3;
        System.out.println(t.maxInWindows(nums,n));

    }
}
