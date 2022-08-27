package com.code.carl.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        //窗口
        HashMap<Integer,Integer> window = new HashMap<>();
        //字串的起始位置
        int start = 0;
        //最大的字串长度
        int max = 0;
        //子串中的第一个元素是谁
        int left = 0;
        //子串中第二个元素是谁。
        //因为是这样的。如果出现了三个不同的元素情况，肯定要丢弃第一个元素的，那么新的字串应该从最左元素的结束位置开始计算
        //例如：[3,3,3,1,2,1,1,2,3,3,4] 当3 3 3 1结束碰到2的时候，应该从3的结尾即1的开始处计算
        //但是也会出现左右颠倒的情况：1 1 1 6 5 6 6 在这里，left = 1 right = 6,如果遇到了 5 ，left = 6 right = 5
        //但是继续向后走，会发现6又出现了，成了5的右边元素，所以如果发现当前的i指向的元素不等于right指向的元素，那么就交换左右元素
        int right = 0;
        for (int i = 0; i < fruits.length; i++) {
            //如果窗口大小小于2
            if (window.size() < 2){
                //添加元素
                if (window.size() == 0){
                    //如果是第一次加入元素那么left = 第一次添加的元素
                    left = fruits[i];
                }
                else {
                    //第二次添加元素那么right = 第二次添加的元素
                    right = fruits[i];
                }
                window.put(fruits[i],i);
                //计算一次只有两个元素时的最大长度
                max = Math.max(i - start + 1,max);
                continue;
            }
            //如果遇到了新的元素，超过了窗口大小
            if (!window.containsKey(fruits[i])){
                //重新计算起始位置
                start = window.get(left) + 1;
                //移除左侧元素
                window.remove(left);
                //放入新元素
                window.put(fruits[i],i);
                //原来的右侧元素变成左侧元素
                left = right;
                //新元素变成右侧元素
                right = fruits[i];
            }
            else{
                //计算窗口大小
                max = Math.max(i - start + 1,max);
                window.put(fruits[i],i);
                //如果左右侧元素发生了颠倒，那么进行纠正
                if (right != fruits[i]){
                    int tmp = left;
                    left = right;
                    right = tmp;
                }
            }
        }
        return max;
    }

    public int totalFruit1(int[] fruits) {
        int max = 0;
        int i = 0;
        Map<Integer,Integer> window = new HashMap<>();
        for (int j = 0; j < fruits.length; j++) {
            window.put(fruits[j],window.getOrDefault(fruits[j],0) + 1);
            while (window.size() >= 3){
                //收缩窗口
                window.put(fruits[i],window.get(fruits[i]) - 1);
                if (window.get(fruits[i]) == 0){
                    window.remove(fruits[i]);
                }
                i ++;
            }
            max = Math.max(max,j - i + 1);
        }
        return max;
    }

    public int totalFruit2(int[] fruits) {
        int left = 0;
        int right = 0;
        int ans = 0;
        HashMap<Integer,Integer> window = new HashMap<>();
        while (right < fruits.length){
            window.put(fruits[right],window.getOrDefault(fruits[right],0) + 1);
            right ++;
            //超过两种水果的时候收缩
            while (window.size() >= 3){
                window.put(fruits[left],window.get(fruits[left]) - 1);
                if (window.get(fruits[left]) == 0){
                    window.remove(fruits[left]);
                }
                left ++;
            }
            ans = Math.max(ans,right - left);
        }
        return ans;
    }
    public static void main(String[] args) {
        TotalFruit t = new TotalFruit();
        int i = t.totalFruit(new int[]{1,2,1});
        System.out.println(i);
    }
}
