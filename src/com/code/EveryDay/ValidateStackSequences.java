package com.code.EveryDay;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (i < pushed.length){
            deque.push(pushed[i ++]);
            while (!deque.isEmpty() && deque.peek() == popped[j]){
                deque.pop();
                j ++;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        boolean b = validateStackSequences.validateStackSequences(new int[]{2, 1, 0}, new int[]{1, 2, 0});
        System.out.println(b);
        System.out.println(((char)7 + '0'));
    }
}
