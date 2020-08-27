package com.theswordreferstooffer.offer;

public class DeleteDuplication {
    /**
     * 先新建一个头节点，然后向后查找值相同的节点，重复查找后删除
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        //没有头节点 建一个头节点
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode pre = first;
        while (p!=null && p.next != null){
            if(p.val == p.next.val){
                int val = p.val;
                while (p!=null && p.val == val){
                    p = p.next;
                }
                pre.next = p;
            }
            else{
                pre = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
