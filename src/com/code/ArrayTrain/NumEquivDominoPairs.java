package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.Comparator;

public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Arrays.sort(dominoes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if((o1[0] == o2[0] && o1[1] == o2[1]) || (o1[1] == o2[0] && o1[0] == o2[1])){
                    return 0;
                }
                else if(o1[0] > o2[0]){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        for (int i = 0; i < dominoes.length; i++) {
            System.out.println(dominoes[i][0] + "," + dominoes[i][1]);
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < dominoes.length - 1; i++) {
            if((dominoes[i][0] == dominoes[i+1][0] && dominoes[i][1] == dominoes[i+1][1])
                    || (dominoes[i][1] == dominoes[i+1][0] && dominoes[i][0] == dominoes[i+1][1])){
                res += count;
                count ++;
            }
            else{
                count = 0;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        new NumEquivDominoPairs().numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}});
    }
}
