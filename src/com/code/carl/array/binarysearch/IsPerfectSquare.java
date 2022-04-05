package com.code.carl.array.binarysearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int left = 1;
        int right = num / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(((double) num / (double) mid) == (double) mid){
                return true;
            }
            else if(((double) num / (double) mid) < (double) mid){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(((double) 3 / (double) 2));
    }
}
