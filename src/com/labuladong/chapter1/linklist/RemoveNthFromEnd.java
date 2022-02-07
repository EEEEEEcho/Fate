package com.labuladong.chapter1.linklist;

import com.code.link.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode yammy = new ListNode(-1);
        yammy.next = head;
        ListNode p1 = yammy;
        ListNode p2 = yammy;
        //ListNode p2 = head;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return yammy.next;
    }
}
