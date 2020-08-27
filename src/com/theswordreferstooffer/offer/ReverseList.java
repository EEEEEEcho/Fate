package com.theswordreferstooffer.offer;

public class ReverseList {
    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
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
    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        ListNode node1 = new ListNode(1);
        ListNode head  = node1;
        for(int i=2;i <= 5; i++){
            ListNode node = new ListNode(i);
            node.next = null;
            node1.next = node;
            node1 = node;
        }
       // System.out.println(r.getLength(head));
        ListNode re = r.ReverseList(head);
        while (re != null){
            System.out.print(re.val + " ");
            re = re.next;
        }
    }
}
