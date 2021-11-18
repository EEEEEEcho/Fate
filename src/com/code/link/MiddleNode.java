package com.code.link;

public class MiddleNode {
    //笨方法，遍历两次
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode ans = head;
        while (head != null){
            length ++;
            head = head.next;
        }
        length = length / 2;
        while (length > 0){
            ans = ans.next;
            length --;
        }
        return ans;
    }
    //技巧版，快慢针，一次遍历
    //快指针每次向前走两步，慢指针每次走一步，快指针到头了，慢指针也就到了中间
    public ListNode middleNode2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
