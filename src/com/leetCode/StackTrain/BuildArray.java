package com.leetCode.StackTrain;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> list = new ArrayList<>();
        for(int i=1; i <=n && index < target.length;i ++ ){
            if(target[index] == i){
                index ++;
                list.add("Push");
            }
            else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BuildArray b = new BuildArray();
        System.out.println(b.buildArray(new int[]{1,3},3));
    }
}
