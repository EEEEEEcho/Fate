package com.qiye;

import java.math.BigInteger;
import java.util.*;

public class TheCowNumber {
    static final int mod = 1000000007;
    public static void main(String[] args) {
        /**
         * 本题重点在于如何处理大数。而不是算法。
         * 算法很简单，就是排序，每选一个数，后一个可选择的就减一
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer array[] = new Integer[n];
        for(int i=0;i < n;i ++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        long ans = 1;
        for(int i=0;i < array.length;i ++){
            ans *= ((array[i] - i) % mod);
            ans %= mod;
        }
        System.out.println(ans);
//        BigInteger result = new BigInteger("1");
//        for(int i=0;i <array.length;i ++){
//            int tmp = array[i] - i;
//            String s = tmp + "";
//            result = result.multiply(new BigInteger(s));
//        }
//        String mod = 1000000007 + "";
//        System.out.println(result.mod(new BigInteger(mod)));
    }
}
