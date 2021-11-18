package com.code.link;

public class DetectCycle {
    //很妙的解法
    //https://labuladong.gitee.io/algo/2/21/54/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                //到了相遇点
                break;
            }
        }
        if (fast == null || fast.next == null){
            //fast遇到空指针，证明无环
            return null;
        }
        //随便让慢的或者快的指针指向头
        slow = head;
        //
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
