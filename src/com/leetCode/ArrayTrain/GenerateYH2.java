package com.leetCode.ArrayTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateYH2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0){
            result.add(1);
            return result;
        }
        result.addAll(Arrays.asList(1,1));
        if (rowIndex == 1){
            return result;
        }
        else{
            int round = rowIndex - 1;
            for (int i = 0;i < round;i ++){
                List<Integer> tmp = new ArrayList<>(result);
                tmp.add(0,0);
                result.add(0);
                for (int j = 0;j < result.size();j ++){
                    result.set(j, result.get(j) + tmp.get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateYH2 g = new GenerateYH2();
        List<Integer> row = g.getRow(4);
        System.out.println(row);
    }
}
