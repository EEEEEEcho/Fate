package com.qiye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheProblemOfTakeBoot {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        String s = br.readLine();
////        String str1[]= s.split(" ");
////        int weights[] = new int[str1.length];
////        for(int i=0;i < str1.length;i ++){
////            weights[i] = Integer.parseInt(str1[i]);
////        }
////        int maxLoad = Integer.parseInt(br.readLine());
////        int count = countLeastBoat(weights,maxLoad);
////        System.out.println(count);
        int weights[] = new int[]{1,3,5,4,4,2};
        int maxLoad = 6;
        System.out.println(countLeastBoat(weights,maxLoad));
    }
    public static int countLeastBoat(int weights[],int maxLoad){
        Arrays.sort(weights);

















        int index = 0;
        //System.out.println(weights.length);
        boolean tag[] = new boolean[weights.length];
        int count = 0;
        int i = 0;
        int j = weights.length - 1;
        while (i <= j){
            if(weights[i] + weights[j] <= maxLoad){
                count ++;
                i ++;
                j --;
            }
            else{
                tag[j] = true;
                j --;
            }
        }
        for(int k=0;k < tag.length;k ++){
            if (tag[k] == true){
                count ++;
            }
        }
        return count;
    }
}
