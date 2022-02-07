package com.code.link;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //加个头节点
        ListNode amy = new ListNode(-1);
        amy.next = head;
        ListNode ans = amy;
        ListNode p1 = amy;
        //要删除倒数第n个，就得找到倒数第n + 1 个。
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = amy;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return ans;
    }
}
