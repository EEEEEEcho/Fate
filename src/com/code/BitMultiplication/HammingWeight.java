package com.code.BitMultiplication;

public class HammingWeight {
    public int hammingWeight(int n) {
        String string = Integer.toBinaryString(n);
        string = string.replace("0","");
        return string.length();
    }

    /**
     * 官方秀死人的解法
     * 采用掩码的思想，可以总结出，对于位运算，一般的操作是进行一次32位的循环
     * @param n
     */
    public int hammingWeight2(int n){
        int bits = 0;
        int mask = 1;
        for(int i = 0;i < 32;i ++){
            System.out.println(mask & n);
            // 按位与， 如果与的结果不为0 则证明此位有1，否则，此位是0
            if((mask & n) !=0 ){
                bits ++;
            }
            // 掩码移动。从 0000 0000 0000 0000 0000 0000 0000 0001
            //        变为 0000 0000 0000 0000 0000 0000 0000 0010
            mask = (mask << 1);
        }
        return bits;
    }

    public int hammingWeight3(int n){
        int bits = 0;
        while (n !=0){
            bits ++;
            n = n & (n - 1);
        }
        return bits;
    }

    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        //System.out.println(2 & 3);
        System.out.println(h.hammingWeight3(3));
    }
}
