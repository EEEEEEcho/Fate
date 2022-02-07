package com.micosoft;

import java.util.*;

public class Main3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ans = Integer.MAX_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int k : A) {
            hashSet.add(k);
        }
        for (int i = 0; i < A.length - hashSet.size() + 1; i++) {
            int j = i;
            HashSet<Integer> set = new HashSet<>();
            while (j < A.length){
                set.add(A[j ++]);
                if (set.size() == hashSet.size()) break;
            }
            if (set.size() == hashSet.size()){
                ans = Math.min(ans,j - i);
                if (ans == hashSet.size()){
                    return ans;
                }
            }
        }
        return ans;
//        LinkedList<Integer> window = new LinkedList<>();
//        int left = 0;
//        int right = 0;
//        while (right < A.length){
//            right ++;
//            if (!hashSet.containsAll(window)){
//                window.add(A[right]);
//            }
//            while (hashSet.containsAll(window)){
//                ans = Math.min(ans,right - left + 1);
//                left ++;
//                window.removeFirst();
//            }
//            if (left > 0) window.addFirst(A[left - 1]);
//        }
//        return ans;
//        return 0;
    }

    public static void main(String[] args) {
        Main3 m = new Main3();
        int[] test = {7,3,7,3,1,3,4,1};
//        for (int i = 0; i < test.length - 2; i++) {
//            System.out.println(test[i]);
//        }
        int solution = m.solution(test);
        System.out.println(solution);
//        List<Integer> list = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//        set.containsAll(list);

    }
}
