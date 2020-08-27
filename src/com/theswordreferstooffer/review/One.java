package com.theswordreferstooffer.review;

public class One {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0){
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0){
            if(array[i][j] < target){
                i ++;
            }
            else{
                if(array[i][j] == target){
                    return true;
                }
                j --;
            }
        }
        return false;
    }
}
