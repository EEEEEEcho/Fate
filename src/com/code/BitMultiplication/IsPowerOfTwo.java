package com.code.BitMultiplication;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        long x = 0;
        int count = 0;
        while (x < n){
            x = (long)Math.pow(2,count);
            count ++;
            System.out.println(x);
            if (x == n){
                return true;
            }
        }
        return false;
    }

    /**
     * 官方题解，二的幂次方的特点：
     * 若n = 2的x次方，且x为自然数（即n为2的幂），则一定满足下列条件：
     *      1. 恒有 n&(n-1) = 0,这是因为：n二进制最高位为1，其余所有位为0；n-1最高位为0其余所有位为1
     *      2.一定满足n > 0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        boolean flg = isPowerOfTwo.isPowerOfTwo(2147483647);
        System.out.println(flg);
    }
}
