package com.theswordreferstooffer.offer;

import java.util.Arrays;

public class DuplicationNumber {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0){
            duplication[0] = -1;
            return false;
        }
        Arrays.sort(numbers);
        for(int i=0 ; i < length - 1;i ++){
            if(numbers[i] == numbers[i + 1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean findDuplicate(int numbers[],int length,int duplication[]){
        if(numbers == null || numbers.length == 0){
            duplication[0] = -1;
            return false;
        }
        //快慢指针
        int slow = 0;
        int fast = 0;
        for(int i=0;i < length;i ++){
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
            if(fast == slow) {
                fast = 0;
                while (fast != slow) {
                    fast = numbers[fast];
                    slow = numbers[slow];
                }
                duplication[0] = slow;
                return true;
            }
        }
        duplication[0] = -1;
        return false;
    }
}
