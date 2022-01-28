package com.underlying;

import java.util.LinkedList;

public class LinkedListUnderlying {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        /**
         * public LinkedList() {
         *     }
         * 这时list的first(指向链表的头) = null,last(指向链表的尾) = null,size = 0
         */
        linkedList.add(1);
        /**
         * public boolean add(E e) {
         *         linkLast(e);
         *         return true;
         * }
         * void linkLast(E e) {
         *     //此时list的last为null  l也就相应的为null
     *         final Node<E> l = last;
     *         //创建一个新的节点，节点的值为e也就是1，节点的prev为l 即null，节点的next为null
     *         final Node<E> newNode = new Node<>(l, e, null);
     *         //list的last指向新创建的节点newNode
     *         last = newNode;
     *         //l此时为null
     *         if (l == null)
     *         //list的first也指向新创建的节点newNode
     *             first = newNode;
     *         else
     *             l.next = newNode;
     *         //list的size++
     *         size++;
     *         //list被修改的次数++
     *         modCount++;
     *     }
         */
        linkedList.add(2);
        /**
         * void linkLast(E e) {
         *     //创建一个引用l指向list中last所指向的对象，本例中为 1
     *         final Node<E> l = last;
         *     //创建一个新的节点，新节点的prev为l，也就是1.新节点的值为e，本例为2。新节点的next为null。
     *         final Node<E> newNode = new Node<>(l, e, null);
         *     //list的last从原来的指向断开，指向新创建的节点newNode
     *         last = newNode;
         *     //l这里指向的是原来的last，也就是1,所以肯定不为null
     *         if (l == null)
     *             first = newNode;
         *     //走到这里，l现在指向的是原来last指向的节点1，然后l的next指向新创建的节点newNode
     *         else
     *             l.next = newNode;
         *     //size + 1
     *         size++;
     *         modCount++;
     *     }
         */
        linkedList.add(3);
        linkedList.remove(2);
        /**
         * public E remove(int index) {
     *         checkElementIndex(index);
     *         return unlink(node(index));
     *     }
         * //找到位于index位置的node
         * Node<E> node(int index) {
     *         // assert isElementIndex(index);
         *     // 以size / 2为中间基准。
     *         // 如果要找的Node在左边
         *     //因为first指向list的头节点，从first开始往后找
     *         if (index < (size >> 1)) {
     *             Node<E> x = first;
     *             for (int i = 0; i < index; i++)
     *                 x = x.next;
     *             return x;
     *         } else {
         *     //否则，从last从后往前找
     *             Node<E> x = last;
     *             for (int i = size - 1; i > index; i--)
     *                 x = x.prev;
     *             return x;
     *         }
     *     }
         *     经典双向链表删除算法
     * E unlink(Node<E> x) {
     *         // assert x != null;
     *         final E element = x.item;
     *         final Node<E> next = x.next;
     *         final Node<E> prev = x.prev;
     *
     *         if (prev == null) {
     *             first = next;
     *         } else {
     *             prev.next = next;
     *             x.prev = null;
     *         }
     *
     *         if (next == null) {
     *             last = prev;
     *         } else {
     *             next.prev = prev;
     *             x.next = null;
     *         }
     *
     *         x.item = null;
     *         size--;
     *         modCount++;
     *         return element;
     *     }
         */
        linkedList.removeFirst();
        /**
         *
         * 删除头节点
         * public E removeFirst() {
     *         final Node<E> f = first;
     *         if (f == null)
     *             throw new NoSuchElementException();
     *         return unlinkFirst(f);
     *     }
     * private E unlinkFirst(Node<E> f) {
 *         // assert f == first && f != null;
 *         final E element = f.item;
 *         final Node<E> next = f.next;
         * //元素置空
 *         f.item = null;
         * //元素的下个元素置空
 *         f.next = null; // help GC
         * //移动头元素
 *         first = next;
         * //如果f的next也为null，那么list成为了空链表，置list的last也为空
 *         if (next == null)
 *             last = null;
 *         else
 *             next.prev = null;
 *         size--;
 *         modCount++;
 *         return element;
 *     }
         */
        linkedList.set(1,999);
        /**
         * 找到位于x的节点，然后修改它的值
         * public E set(int index, E element) {
     *         checkElementIndex(index);
     *         Node<E> x = node(index);
     *         E oldVal = x.item;
     *         x.item = element;
     *         return oldVal;
     *     }
         */
        System.out.println(linkedList);
    }
}
