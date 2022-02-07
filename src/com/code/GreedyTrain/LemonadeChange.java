package com.code.GreedyTrain;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;
        //Arrays.sort(bills);
        for(int i=0;i < bills.length;i ++){
            if(bills[i] == 5){
                countFive ++;
            }
            if(bills[i] == 10){
                countFive --;
                countTen ++;
            }
            if(bills[i] == 20){
                if(countTen >= 1){
                    countTen --;
                    countFive --;
                }
                else{
                    countFive -= 3;
                }
            }
            if(countFive < 0 || countTen < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        System.out.println(l.lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));
    }
}
