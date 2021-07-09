package com.code.StackTrain;

import java.util.*;

public class NextGreaterElement {
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int length1 = nums1.length;
//        int[] result = new int[length1];
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for(int i=0;i < nums2.length;i ++){
//            arrayList.add(nums2[i]);
//        }
//        for(int i=0;i < length1;i ++){
//            for(int j = arrayList.indexOf(nums1[i]);j < nums2.length;j ++){
//                if(nums2[j] > nums1[i]){
//                    result[i] = nums2[j];
//                    break;
//                }
//                else{
//                    result[i] = -1;
//                }
//            }
//        }
//        return result;
//    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1;i >= 0;i --){
            while (!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.put(nums2[i],-1);
            }
            else{
                result.put(nums2[i],stack.peek());
            }
            //result. = stack.isEmpty()? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] answer = new int[nums1.length];
        for(int i=0;i < nums1.length;i ++){
            answer[i] = result.get(nums1[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] result = nextGreaterElement.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
        for(Integer integer:result){
            System.out.println(integer);
        }
    }
}
