package com.code.Sort;

import java.util.Arrays;

public class Average {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for(int i = 1; i <= salary.length - 2;i ++){
            System.out.println(salary[i]);
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Average().average(new int[]{4000,3000,1000,2000}));
    }
}
