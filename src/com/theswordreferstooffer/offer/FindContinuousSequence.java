package com.theswordreferstooffer.offer;

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList arrayList = new ArrayList();
        if(sum <= 1){
            return arrayList;
        }
        int end = 0;
        if(sum % 2 == 0){
            end = sum / 2;
        }
        else{
            end = sum / 2 + 1;
        }
        for(int i=1;i <= end;i ++){
            int tmp = 0;
            int index = 0;
            for(int j=i;j <= end;j ++){
                tmp += j;
                if(tmp == sum){
                    index = j;
                    break;
                }
                if(tmp > sum){
                    break;
                }
            }
            if(index != 0){
                ArrayList arr = new ArrayList();
                for(int k = i;k <= index;k ++){
                    arr.add(k);
                }
                arrayList.add(arr);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        System.out.println(f.FindContinuousSequence(2));
    }
}
