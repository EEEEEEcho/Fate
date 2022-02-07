package com.code.GreedyTrain;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int count = 0;
        int Rcount = 0;
        int Lcount = 0;
        for(int i = 0;i < s.length();i ++){
            if(s.charAt(i) == 'R'){
                Rcount ++;
            }
            if(s.charAt(i) == 'L'){
                Lcount ++;
            }
            if (Rcount == Lcount){
                Rcount = 0;
                Lcount = 0;
                System.out.println(i);
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BalancedStringSplit b = new BalancedStringSplit();
        System.out.println(b.balancedStringSplit("LLLLRRRR"));
    }
}
