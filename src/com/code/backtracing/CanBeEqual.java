package com.code.backtracing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length){
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]){
                return false;
            }
        }
        return true;
    }
}
