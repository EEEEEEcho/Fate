package com.code.StackTrain;

import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null){
            length ++;
            p = p.next;
        }
        p = head;
        int tmp = 0;
        int pre = 0;
        if(length % 2 == 0){
            pre = length / 2 - 1;
        }
        else{
            pre = length / 2;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        while (p != null){
            if (tmp >= pre + 1){
                stack.addFirst(p);
            }
            tmp ++;
            p = p.next;
        }

        p = head;
        tmp = 0;
        while (p != null){
            if (tmp == pre){
                p.next = null;
                break;
            }
            p = p.next;
            tmp ++;
        }

        p = head;
        while (p != null && stack.size() > 0){
            ListNode node = stack.removeFirst();
            ListNode next = p.next;
            p.next = node;
            node.next = next;
            p = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        ReorderList r = new ReorderList();
        r.reorderList(node1);
    }
}
