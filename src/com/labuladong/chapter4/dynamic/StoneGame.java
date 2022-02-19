package com.labuladong.chapter4.dynamic;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int alice = 0;
        int bob = 0;
        int left = 0;
        int right = piles.length - 1;
        while (left <= right){
            if (piles[left] >= piles[right]){
                alice += piles[left ++];
            }
            else{
                alice += piles[right --];
            }

            if (piles[left] >= piles[right]){
                bob += piles[left ++];
            }
            else{
                bob += piles[right --];
            }
        }
        return alice > bob;
    }
}
