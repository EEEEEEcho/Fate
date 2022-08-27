package com.code.carl.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 递归来做层叠嵌套（可以理解是开k层for循环），
 * 每一次的递归中嵌套一个for循环，
 * 那么递归就可以用于解决多层嵌套循环的问题了。
 */
public class Combine {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrace(1,k,n,new ArrayDeque<>());
        return result;
    }
    public void backTrace(int start, int k, int n,ArrayDeque<Integer> arrayDeque){
        if (arrayDeque.size() == k){
            result.add(new ArrayList<>(arrayDeque));
        }
        else {
            for (int i = start; i <= n - (k - arrayDeque.size()) + 1; i++) {
                arrayDeque.addLast(i);
                backTrace(i + 1,k,n,arrayDeque);
                arrayDeque.removeLast();
            }
        }
    }
}
