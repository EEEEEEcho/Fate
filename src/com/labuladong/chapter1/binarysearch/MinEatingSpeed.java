package com.labuladong.chapter1.binarysearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (f(piles,mid) == h){
                right = mid - 1;
            }
            else if (f(piles,mid) < h){
                right = mid - 1;
            }
            else if(f(piles,mid) > h){
                left = mid + 1;
            }
        }
        return left;
    }

    //定义：速度为x时，需要f(x)小时吃完所有香蕉
    //f(x)随着x的增加而减小
    private int f(int[] piles,int x){
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0){
                hours ++;
            }
        }
        return hours;
    }

    //这个函数不对，因为会改数组，不好，这里是求的是速度，应该求时间
//    private int canEat(int[] piles,int target,int h){
//        int[] tmp = new int[piles.length];
//        System.arraycopy(piles,0,tmp,0,piles.length);
//        int i = 0;
//        while (h > 0){
//            if(i >= tmp.length - 1){
//                return 2;
//            }
//            tmp[i] -= target;
//            if (tmp[i] <= 0){
//                i ++;
//            }
//            h --;
//        }
//        if (i < tmp.length && tmp[tmp.length - 1] > 0) return 1;
//        return 0;
//    }

    public static void main(String[] args) {
        MinEatingSpeed m = new MinEatingSpeed();
        m.minEatingSpeed(new int[]{30,11,23,4,20},5);
    }
}
