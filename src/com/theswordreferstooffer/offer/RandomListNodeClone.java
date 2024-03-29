package com.theswordreferstooffer.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向 下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接 返回空）
 */
class RandomListNode{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode tmp = head;
        //构造链表，先复制next部分，后复制random部分
        while (pHead.next != null){
            tmp.next = new RandomListNode(pHead.next.label);
            if(pHead.next.random != null){
                tmp.random = new RandomListNode(pHead.random.label);
            }
            tmp = tmp.next;
            pHead = pHead.next;
        }
        return head;
    }
}
