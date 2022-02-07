package com.theswordreferstooffer.offer;
public class DoublePowInt {
    /**
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
     * 求 base 的 exponent 次方。
     * 不得使用库函数，不需要考虑大数问题!!
     * 不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情 况。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        //return Math.pow(base,exponent);
        double res = 0;
        if(equal(base,0)){
            return 0;
        }
        if(exponent == 0){
            return 1.0;
        }
        if(exponent > 0){
            return mutiple(base,exponent);
        }
        else{
            //要注意 求小于0次方
            return mutiple(1/base,-exponent);
        }
    }
    public double mutiple(double base,int exponent){
        double sum = 1;
        for(int i=0;i < exponent;i ++){
            sum *= base;
        }
        return sum;
    }
    private boolean equal(double base,double target){
        /**
         * 解决误差问题
         */
        if(base - target > -0.000001 && base - target < 0.000001){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DoublePowInt().Power(3.0,-1));
    }
}
