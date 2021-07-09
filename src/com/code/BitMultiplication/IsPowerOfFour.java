package com.code.BitMultiplication;

public class IsPowerOfFour {
//    public boolean isPowerOfFour(int n) {
//        long result = 0;
//        while (result < n){
//            if(n == (long) Math.pow(4,result)){
//                return true;
//            }
//            result ++;
//        }
//        return false;
//    }

    /**
     * 思维定式了，
     * 如果数字为4的幂x=4的a次方，则a=log以4为底x,又即 1/2log以2为底x。所以只需检查log以2为底x是否为偶数就能判断
     * x是否为4的幂
     * @param n
     * @return
     */
    public boolean isPowerOfFour1(int n) {
        // Math.log(n) / Math.log(2) 就是log以2为底的n
        return (n > 0) && (Math.log(n) / Math.log(2) % 2 == 0);
    }

    /**
     * 位运算，
     * 首先，4的幂的二进制的特点是
     * 1
     * 10
     * 1000
     * 100000
     * 可以发现，最高位的1是出现在偶数位0 2 4 6 8 ...的
     * 所以，在num已经是2的幂的前提下，成为四的幂就要和10101010....1010相与 肯定是0
     * 而10101010...1010的十六进制表示位0xaaaaaaaaa
     * @param n
     * @return
     */
    public boolean isPowerOfFour2(int n) {
        // Math.log(n) / Math.log(2) 就是log以2为底的n
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
