package com.code.ArrayTrain;

public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == 1 && bits[i + 1] == 1){
                bits[i] = 3;
                bits[i + 1] = 3;
                i ++;
            }
            else if (bits[i] == 1 && bits[i + 1]  == 0){
                bits[i] = 4;
                bits[i + 1] = 4;
                i++;
            }
            else if(bits[i] == 0 && bits[i + 1] == 1){
                bits[i] = 5;
            }
        }
        if (bits[bits.length - 1] == 0){
            bits[bits.length - 1] = 5;
        }
        return bits[bits.length - 1] == 5;
    }
}
