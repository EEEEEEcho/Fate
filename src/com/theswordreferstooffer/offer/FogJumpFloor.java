package com.theswordreferstooffer.offer;

public class FogJumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 此题的突破口在台阶数；台阶数不一样，结果就不一样；由台阶数来找规律。
     * 1阶 ： 1
     * 2阶 ： 2
     * 3阶 ： 3
     * 4阶 ： 5
     * 5阶 ： 8
     * 6阶 ： 13  ...
     * 转换为斐波那契数列
     * @param n
     * @return
     */
    public int JumpFloor(int n){
        if(n < 3){
            return n;
        }
        int result = 0;
        int oneStep = 2;
        int twoStep = 1;
        for(int i=3;i <=n ;i ++){
            result = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = result;
        }
        return result;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * 同样找规律
     * * 1阶 ： 1
     *   2阶 ： 2
     *   3阶 ： 4..
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int)Math.pow(2,target - 1);
    }
}
