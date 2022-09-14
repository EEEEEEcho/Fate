package com.effective;

import com.qiye.Solution;

import java.util.*;

public class Schedule {
    /* Write Code Here */
    public int[] schedule(int[][] arr) {
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][2];
        return null;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int arr_rows = 0;
        int arr_cols = 0;
        arr_rows = in.nextInt();
        arr_cols = in.nextInt();

        int[][] arr = new int[arr_rows][arr_cols];
        for(int arr_i=0; arr_i<arr_rows; arr_i++) {
            for(int arr_j=0; arr_j<arr_cols; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        res = new Schedule().schedule(arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
