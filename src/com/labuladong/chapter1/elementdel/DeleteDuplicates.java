package com.labuladong.chapter1.elementdel;


import com.code.link.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if(slow.val != fast.val){
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return h.next;
    }
}
