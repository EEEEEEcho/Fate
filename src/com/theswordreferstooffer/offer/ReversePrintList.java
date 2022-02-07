package com.theswordreferstooffer.offer;

import com.echo.A;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

public class ReversePrintList {
    /**
     * 用栈实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;

    }

    /**
     * 递归实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode != null){
            if(listNode.next != null){
                arrayList = printListFromTailToHead1(listNode.next);
            }
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list);
    }
}
