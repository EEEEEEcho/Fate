package com.code.linkListTrain;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null){
                return head;    //已经翻转到不足K个了，直接返回head
            }
            b = b.next;
        }
        //否则，够K个，那就先翻转前K个
        ListNode newHead = reverse(a,b);
        //翻转过后，头变成了尾
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    /**
     * 翻转[a,b)的链表
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt;
        while (cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
