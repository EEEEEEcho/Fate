package com.code.carl.linklist.swap;

import com.code.linkListTrain.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode p = head;
        while (p != null && p.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            ListNode x = cur.next.next;
            cur.next.next = tmp;
            tmp.next = x;
            cur = cur.next.next;
            p = cur.next;
        }
        return dummy.next;
    }
}
