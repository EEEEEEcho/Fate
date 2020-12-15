package com.leetCode.BitMultiplication;

public class FindComplement {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] array = s.toCharArray();
        for(int i = 0;i < array.length;i ++){
            if(array[i] == '0'){
                array[i] = '1';
            }
            else {
                array[i] = '0';
            }
        }
        return Integer.parseInt(new String(array),2);
    }
    public int findComplement2(int num) {
        // 通过位运算获取最大位数的位置，然后利用抑或运算取反
        int maxBit = 0;
        int tmpNum = num;
        while (tmpNum > 0){
            maxBit ++;
            tmpNum >>= 1;
        }
        //1 左移最大位数减一之后变成01111...1 然后与num想与即取反
        return num ^ ((1 << maxBit) - 1);
    }

    public static void main(String[] args) {
        FindComplement f = new FindComplement();
        System.out.println(f.findComplement(5));
    }
}
