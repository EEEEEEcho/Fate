package com.code.codertop;

import com.code.link.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode f = dummy;
        ListNode p = head;

        for (int i = 0; i < left - 1; i++) {
            f = f.next;
            p = p.next;
        }

        ListNode tmpHead = f;
        ListNode tail = p;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmp = p.next;
            p.next = f;
            f = p;
            p = tmp;
        }
        tmpHead.next = f;
        tail.next = p;

        return dummy.next;
    }

}
