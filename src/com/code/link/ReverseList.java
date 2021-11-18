package com.code.link;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        return reverse(head);
    }
    //递归反转
    public ListNode reverse(ListNode head){
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
