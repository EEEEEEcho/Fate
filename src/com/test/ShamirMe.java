package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class ShamirMe {
    public static void main(String[] args) {
        //存放多项式系数 a1,a2,a3.....
        ArrayList<Long> params = new ArrayList<>();
        //多项式中求出的碎片密钥的y值
        ArrayList<Long> valuesOfY = new ArrayList<>();
        //多项式中求出的碎片密钥的x值
        ArrayList<Long> valuesOfX = new ArrayList<>();
        // 密钥的值，会放到多项式的 f[0]处
        int secret = 13;

        // 生成大素数P 多项式 mod p 中的 p
        Random rand = new Random();
        int bit_num = rand.nextInt(29) + 2;// 随机2到31位
        BigInteger q = BigInteger.probablePrime(bit_num, rand);// 生成一个随机大素数,必须大于输入的随机整数
        long p = q.longValue();
        while (p < secret) {// 如果不大于输入的数
            bit_num = rand.nextInt(29) + 2;
            q = BigInteger.probablePrime(bit_num, rand);
            p = q.longValue();
        }
        System.out.println(p);

        // 自定义门限
        int threshold = 3;
        // 自定义碎片密钥持有者的数量
        int holders = 10;

        // 根据门限值生成随机系数，门限值为3，那么随机的系数就要有两个，因为第一个系数是密钥
        for(int i = 0;i < threshold - 1;i ++){
            // 生成的随机数要小于 p ，并且要大于0
            long param = (long) (Math.random() * p);
            while (param == 0){
                param = (long) (Math.random() * p);
            }
            params.add(param);
        }

        // 生成多项式中随机的X的值,有多少个持有人生成多少个X值，
        // 方便计算，生成的点的值在100以内
        for(int i = 0;i < holders;i ++){
            long x = (long) (Math.random() * 100);
            valuesOfX.add(x);
        }


    }
}
