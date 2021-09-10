package com.code.ArrayTrain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = num.length - 1;i >= 0;i --){
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10){
                k ++;   //核心就在这里。如果出现了进位，并不是往结果里进位。而是去被加数里进位
                sum -= 10;
            }
            list.add(sum);
        }
        //处理最后的最高位
        for (; k > 0; k /= 10) {
            list.add(k % 10);
        }
        Collections.reverse(list);
        return list;
    }
    //模板处理
    /*
    * 只要记住这个公式，不管两个数是列表形式，还是数组形式，都不会写错！

    <公式>

    当前位 = (A 的当前位 + B 的当前位 + 进位carry) % 10
    注意，AB两数都加完后，最后判断一下进位 carry, 进位不为 0 的话加在前面。

    <加法模板>

    while ( A 没完 || B 没完)
        A 的当前位
        B 的当前位

        和 = A 的当前位 + B 的当前位 + 进位carry

        当前位 = 和 % 10;
        进位 = 和 / 10;

    判断还有进位吗
    * */
    public List<Integer> addToArrayForm2(int[] num, int k){
        int n = num.length;
        LinkedList<Integer> ans = new LinkedList<>();
        int i = n - 1;
        int sum = 0;
        int carry = 0; //进位
        while (i >= 0 || k != 0){
            int x = i >= 0? num[i] : 0; // 取数组中的数
            int y = k != 0? k % 10 : 0; //取k

            sum = x + y + carry;    //和为当前两个值加上进位

            carry = sum / 10;       //判断这次相加是否有进位,有进位的话，取得进位的值

            k = k / 10;
            i --;
            ans.addFirst(sum % 10); //前面就算有进位也处理过了，因此此处只要取余就行了
        }
        if (carry != 0){
            ans.addFirst(carry);
        }

        return ans;
    }

    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        int[] arr = new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
//        int[] arr = new int[]{0};
        List<Integer> integers = a.addToArrayForm(arr, 516);
        System.out.println(integers);
    }
}
