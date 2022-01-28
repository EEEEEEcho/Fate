package com.code.topOnehundred;

import java.util.Arrays;

public class Trap {
    //1.行遍历
    public int trap1(int[] height) {
        int maxHeight = Arrays.stream(height).max().getAsInt();
        int nowHeight = 0;
        int ans = 0;
        while (nowHeight <= maxHeight){
            for (int i = 0; i < height.length; i++) {
                if (i - 1 >=0 && i + 1 <= height.length - 1
                        && height[i] == nowHeight && height[i - 1] > nowHeight
                        && height[i + 1] > nowHeight){
                    ans ++;
                }
            }
            nowHeight ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int trap1 = trap.trap1(new int[]{3, 2, 1, 2, 1});
        System.out.println(trap1);
    }
}
