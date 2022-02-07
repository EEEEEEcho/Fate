package com.labuladong.chapter1.binarysearch;

import java.util.Arrays;

public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (f(weights,mid) == days){
                right = mid - 1;
            }
            else if (f(weights,mid) > days){
                left = mid + 1;
            }
            else if(f(weights,mid) < days){
                right = mid - 1;
            }
        }
        return left;
    }
    //x = 载重量
    //f(x) = 以x为载重量，运输所有货物需要的天数
    private int f(int[] weights,int weight){
        int ans = 0;
        int total = weight;
        for (int i = 0; i < weights.length; i++) {
            if (total >= weights[i]){
                total -= weights[i];
            }
            else{
                ans ++;
                total = weight;
                total -= weights[i];
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        ShipWithinDays s = new ShipWithinDays();
        int f = s.f(new int[]{1,2,3,4,5,6,7,8,9,10}, 15);
        System.out.println(f);
    }
}
