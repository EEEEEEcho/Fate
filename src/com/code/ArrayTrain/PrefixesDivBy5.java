package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {
    //秦九韶算法
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = new PrefixesDivBy5().prefixesDivBy5(new int[]{1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1});
        System.out.println(booleans);

    }
}
