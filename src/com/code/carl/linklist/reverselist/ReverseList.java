package com.code.carl.linklist.reverselist;

import com.code.linkListTrain.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode f = null;
        ListNode p = head;
        while (p != null){
            ListNode tmp = p.next;
            p.next = f;
            f = p;
            p = tmp;
        }
        return f;
    }

    public ListNode reverseList1(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode last = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
