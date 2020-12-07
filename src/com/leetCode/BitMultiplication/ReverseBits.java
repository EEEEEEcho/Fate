package com.leetCode.BitMultiplication;

public class ReverseBits {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        if(sb.length() < 32){
            int len = sb.length();
            while (len < 32){
                sb.append("0");
                len ++;
            }
        }
        int result = Integer.parseUnsignedInt(sb.toString(),2);
        return result;
    }

    /**
     * 与反转十进制整数使用取模除十累加的方法类似，
     *
     * 十进制：ans = ans * 10 + n % 10; n = n / 10;
     * 二进制：ans = ans * 2 + n % 2; n = n / 2;
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int res = 0;
        for(int i=0;i < 32;i ++){
            res = (res << 1) + n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(43261596));
    }
}
