package com.theswordreferstooffer.offer;

public class RectCover {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 比如n=3时，2*3的矩形块有3种覆盖方法：
     * 斐波那契数列思想
     * n = 1,1
     * n = 2,2
     * n = 3,3
     * n = 4,5
     * n = n, re = f(n - 1) + f(n - 2)
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int result = 0;
        int one = 2;
        int two = 1;
        for(int i=2;i < target;i ++){
            result = one + two;
            two = one;
            one = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = new RectCover().rectCover(3);
        System.out.println(n);

    }
}
