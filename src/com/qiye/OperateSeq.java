package com.qiye;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OperateSeq {
    /**
     * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
     * 1、将a_i放入b序列的末尾
     * 2、逆置b序列
     * 小易需要你计算输出操作n次之后的b序列。
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 找规律：如果是偶数个数 4   1 2 3 4 操作完成之后 就是4 2 1 3 把偶数保存 反转 然后 奇数不动 拼到反转的偶数后
         * 如果是奇数个数 5   1 2 3 4 5 操作完成之后就是 5 3 1 2 4 把奇数保存 反转 然后偶数不懂拼到反转的奇数后
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> listOdd = new ArrayList<>();
        ArrayList<String> listEven = new ArrayList<>();
        int index = 1;
        for(int i=0;i < n;i ++){
            String s = scanner.next();
            if(index % 2 != 0){
                listOdd.add(s);
            }
            else{
                listEven.add(s);
            }
            index ++;
        }
        if(n % 2 == 0){
            Collections.reverse(listEven);
            listEven.addAll(listOdd);
            for(String s : listEven){
                System.out.print(s + " ");
            }
        }
        else {
            Collections.reverse(listOdd);
            listOdd.addAll(listEven);
            for(String s : listOdd){
                System.out.print(s + " ");
            }
        }

    }
}
