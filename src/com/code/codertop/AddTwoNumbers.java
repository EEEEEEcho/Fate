package com.code.codertop;

import com.code.link.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int advance = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + advance;
            advance = sum / 10;
            int value = sum % 10;
            ListNode node = new ListNode(value);
            head.next = node;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = l1.val + advance;
            advance = sum / 10;
            int value = sum % 10;
            ListNode node = new ListNode(value);
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val + advance;
            advance = sum / 10;
            int value = sum % 10;
            ListNode node = new ListNode(value);
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        if (advance > 0){
            ListNode node = new ListNode(advance);
            head.next = node;
        }
        return dummy.next;
    }
}
