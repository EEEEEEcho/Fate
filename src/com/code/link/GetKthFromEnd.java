package com.code.link;

public class GetKthFromEnd {
    //遍历两次
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp = head;
        int n = 0;
        while (tmp != null){
            n ++;
            tmp = tmp.next;
        }
        int count = n - k;
        while (count > 0){
            if (head != null){
                head = head.next;
            }
            count --;
        }
        return head;
    }
    //遍历一次,快慢指针
    public ListNode getKthFromEnd2(ListNode head,int k){
        ListNode p1 = head;
        //快针先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        //快慢针同时走，此时快针再走n - k 就到了链尾
        //而慢针也走了n-k，也就是到了倒数第k个
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
