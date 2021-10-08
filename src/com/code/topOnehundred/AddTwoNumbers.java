package com.code.topOnehundred;



public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode();
        ListNode head = first;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = 0;
            int y = 0;
            if (l1 != null){
                x = l1.val;
            }
            if (l2 != null){
                y = l2.val;
            }
            sum = x + y + carry;
            carry = sum / 10;

            ListNode next = new ListNode(sum % 10);
            first.next = next;
            first = next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            ListNode next = new ListNode(carry);
            first.next = next;
            first = next;
        }
        return head.next;
    }
}
