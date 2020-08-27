package com.theswordreferstooffer.offer;

public class SumSolution {
    public int result = 0;
    public int Sum_Solution(int n) {
        if(n > 0){
            return n + Sum_Solution(n - 1);
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        SumSolution s = new SumSolution();
        int re = s.Sum_Solution(3);
        System.out.println(re);
    }
}
