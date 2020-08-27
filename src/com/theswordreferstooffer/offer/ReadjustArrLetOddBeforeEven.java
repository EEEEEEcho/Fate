package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ReadjustArrLetOddBeforeEven {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        ArrayList odd = new ArrayList();
        ArrayList even = new ArrayList();
        for(int i=0;i < array.length;i ++){
            if(array[i] %2 == 0){
                even.add(array[i]);
            }
            else{
                odd.add(array[i]);
            }
        }
        int j = 0;
        for(;j < odd.size();j ++){
            array[j] = (int)odd.get(j);
        }
        for(int i = 0;i < even.size();i ++,j++){
            array[j] = (int)even.get(i);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        ReadjustArrLetOddBeforeEven r = new ReadjustArrLetOddBeforeEven();
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        r.reOrderArray(array);
    }
}
