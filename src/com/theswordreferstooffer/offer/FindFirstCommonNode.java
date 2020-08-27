package com.theswordreferstooffer.offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，
 * 所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNode {
    /**
     * 注意链表不等长,先找出长的链表，先走几步
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        if(len1 > len2){
            int step = len1 - len2;
            while (step > 0){
                n1 = n1.next;
                step --;
            }
        }
        else{
            int step = len2 - len1;
            while (step > 0){
                n2 = n2.next;
                step --;
            }
        }
        while (n1 != null && n2 != null){
            if(n1.val == n2.val){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }
    public int getLength(ListNode node){
        ListNode tmp = node;
        if(tmp == null){
            return 0;
        }
        int count = 0;
        while (tmp != null){
            count ++;
            tmp = tmp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        node4.next = node5;
        ListNode t = new FindFirstCommonNode().FindFirstCommonNode(node1,node4);
        System.out.println(t.val);
    }
}
