package com.labuladong.chapter1.linklist;

import com.code.link.ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if (fast.next != null){
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
