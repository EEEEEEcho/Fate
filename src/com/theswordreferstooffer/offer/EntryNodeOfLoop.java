package com.theswordreferstooffer.offer;

public class EntryNodeOfLoop {
    /**
     * 思路请见 https://my.oschina.net/songjilong/blog/3159816
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = pHead;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                if(fast == slow){
                    return slow;
                }
            }
        }
        return null;
    }
}
