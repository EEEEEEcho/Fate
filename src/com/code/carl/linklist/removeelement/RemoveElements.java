package com.code.carl.linklist.removeelement;

import com.code.linkListTrain.ListNode;

import java.util.LinkedList;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head != null){
            if (head.val != val){
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        p.next = null;
        return dummy.next;
    }
}
