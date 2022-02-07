package com.theswordreferstooffer.offer;
public class TheReciprocalOfTheKNumber {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。链表无头节点！！！
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        int length = getLength(head);
        if(k > length){
            return null;
        }
        int index = length - k;
        while (index > 0){
            head = head.next;
            index --;
        }
        return head;
    }
    private int getLength(ListNode head){
        ListNode p = head;
        int count = 0;

        while (p != null){
            count ++;
            p = p.next;
        }
        return count;
    }

    /**
     * 书上的方法
     * 定义一快一慢两个指针，快指针走 K 步，然后慢指针开始走，
     * 快指针到尾 时，慢指针就找到了倒数第 K 个节点。
     * @param
     */
    public ListNode FindKthToTail1(ListNode head,int k) {
        if(head == null || k < 1){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0){
            if(fast.next == null){
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode head  = node1;
        for(int i=2;i <= 5; i++){
            ListNode node = new ListNode(i);
            node.next = null;
            node1.next = node;
            node1 = node;
        }
        System.out.println(new TheReciprocalOfTheKNumber().FindKthToTail(head,1).val);

    }
}
