package com.theswordreferstooffer.offer;

public class SumDoNotUseOperator {
    /**
     * 两个数的和可以分解为（两数异或）与（两数按位与左移一位）的和，这可以是迭代。
     * 两数异或:是将两个数中不同的二进制位直接相加的结果，
     * 两数按位与:则是得到进位的结果，
     * 进位左移一位和异或结果:重复1,2。
     * 因此在始终存在进位的情况下，将异或结果不等于两数之和，直到进位数为0，异或结果就是两数之和。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int result = 0;
        while (num2 != 0){
            result = num1 ^ num2;
            num2 = (num1 & num2)  << 1;
            num1 = result;
        }
        return num1;
    }
}
