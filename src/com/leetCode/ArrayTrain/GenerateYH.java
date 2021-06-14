package com.leetCode.ArrayTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateYH {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] tmpArray = new Integer[i + 1];
            tmpArray[0] = 1;
            tmpArray[tmpArray.length - 1] = 1;
            List<Integer> tmp = new ArrayList<Integer>();
            if (i < 2){
                Collections.addAll(tmp,tmpArray);
                result.add(tmp);
                continue;
            }
            List<Integer> last = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                tmpArray[j] = last.get(j-1) + last.get(j);
            }
            Collections.addAll(tmp,tmpArray);
            result.add(tmp);
        }
        return result;
    }
}
