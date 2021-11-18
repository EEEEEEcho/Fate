package com.code.linkListTrain;

public class ReverseBetween {
    //正儿八经从原链表中扣出一部分，然后翻转之后放回去
    //空间换时间
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (left > right){
            return null;
        }
        else if(left == right){
            return head;
        }
        else{
            int preIndex = left - 1;
            ListNode amy = new ListNode(-1);
            amy.next = head;
            ListNode p1 = amy;
            ListNode pre = null;

            ListNode tmpHead = new ListNode(-1);
            boolean flg = true;
            ListNode tailPoint = null;

            for (int i = 1; i <= right; i++) {
                if (i == preIndex){
                    pre = p1;
                }
                if(i >= left && i <= right){
                    ListNode node = new ListNode(p1.val);
                    node.next = tmpHead.next;
                    tmpHead.next = node;
                    if (flg){
                        tailPoint = node;
                        flg = false;
                    }
                }
                p1 = p1.next;
            }

            if (pre != null && tailPoint != null){
                pre.next = tmpHead.next;
                tailPoint.next = p1.next;
            }
            return amy.next;
        }
    }

    //递归翻转，明天再看吧
    public ListNode reverseBetween(ListNode head, int left, int right){
        return null;
    }
}
