package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] ints : image) {
            reverse(ints);
        }
        for (int i = 0;i < image.length;i ++){
            for (int j = 0;j < image[0].length;j ++){
                if (image[i][j] == 1){
                    image[i][j] = 0;
                }
                else if(image[i][j] == 0){
                    image[i][j] = 1;
                }
            }
        }
        return image;
    }
    private void reverse(int[] array){
        int i = 0;
        int j = array.length - 1;
        while (i <= j){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i ++;
            j --;
        }
    }
}
