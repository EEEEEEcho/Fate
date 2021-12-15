package com.labuladong.chapter1.linklist;

import com.code.link.ListNode;

public class MergerTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = l2;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        while (l1 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null){
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        return head.next;
    }
}
