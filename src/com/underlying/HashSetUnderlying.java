package com.underlying;

import com.proxyStudy.staticProxy.Student;

import java.util.HashSet;

public class HashSetUnderlying {
    public static void main(String[] args) {
//        HashSet hashSet = new HashSet();
//        hashSet.add("lucky");   //加入成功
//        hashSet.add("lucky");   //加入失败
//        hashSet.add(new Student("Echo")); //加入成功
//        hashSet.add(new Student("Echo")); //加入成功
//        hashSet.add(new String("SXS")); //加入成功
//        hashSet.add(new String("SXS")); //加入失败,虽然这里是添加了一个String对象，但是还是加入失败的
//        System.out.println(hashSet);
        HashSet hashSet = new HashSet();
        /**
         * 1.执行构造器
         * public HashSet() {
     *         map = new HashMap<>();
     *     }
         */
        hashSet.add("java");
        /**
         * public boolean add(E e) {
         *     //这个PRESENT是一个：private static final Object PRESENT = new Object();  用来占位的东西
     *         return map.put(e, PRESENT)==null;
         *
     *     }
         * //调用put方法
         * public V put(K key, V value) {
     *         return putVal(hash(key), key, value, false, true);
     *     }
         * //先调用hash(key)计算key 的hash值
         * static final int hash(Object key) {
     *         int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     *     }
         * //然后调用putVal方法
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
     *                    boolean evict) {
         *     //1.定义辅助变量
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
         *     //2.table是hash表，是一个Node<K,V>[]. 判断table是否为null，或者table的长度是否为0
     *         if ((tab = table) == null || (n = tab.length) == 0)
         *         //执行第一次扩容，扩容至16个空间
         *         //resize()是扩容方法。
     *             n = (tab = resize()).length;
         *     //根据由key得到hash值，计算该key应该存放到hash表的哪个位置。并把这个位置的对象，赋值给p
         *     //并判断p是否为空
     *         if ((p = tab[i = (n - 1) & hash]) == null)
         *         //如果p为空，那么证明该位置没有存放元素，就创建一个Node,将hash(key),key,固定的值PRESENT,以及next传入
     *             tab[i] = newNode(hash, key, value, null);
     *         else {
     *             Node<K,V> e; K k;
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
     *                 e = p;
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
     *                 for (int binCount = 0; ; ++binCount) {
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     p = e;
     *                 }
     *             }
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
         *     //看看添加一个元素之后的容量是否超过了由装载因子 * 当前容量计算出来的阈值。
     *         if (++size > threshold)
         *         //如果超过了，就扩容
     *             resize();
     *         afterNodeInsertion(evict);
         *     //返回null代表插入成功，如果不是null，就证明元素重复了，返回重复的元素
     *         return null;
     *     }
         * final Node<K,V>[] resize() {
     *         Node<K,V>[] oldTab = table;
     *         int oldCap = (oldTab == null) ? 0 : oldTab.length;
     *         int oldThr = threshold;
     *         int newCap, newThr = 0;
     *         if (oldCap > 0) {
     *             if (oldCap >= MAXIMUM_CAPACITY) {
     *                 threshold = Integer.MAX_VALUE;
     *                 return oldTab;
     *             }
     *             else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
     *                      oldCap >= DEFAULT_INITIAL_CAPACITY)
     *                 newThr = oldThr << 1; // double threshold
     *         }
     *         else if (oldThr > 0) // initial capacity was placed in threshold
     *             newCap = oldThr;
     *         else {               // zero initial threshold signifies using defaults
         *         //如果oldCap=0,也就是初始时，hash表为空。
         *         //那么newCap = DEFAULT_INITIAL_CAPACITY = 16;
     *             newCap = DEFAULT_INITIAL_CAPACITY;
         *         //newThr = DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY
         *         //其中DEFAULT_LOAD_FACTOR是装载因子。默认为0.75.
         *         //也就是，当阈值达到0.75 * 16 = 12时，就会扩容，这种机制是为了缓冲。
     *             newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
         *
     *         }
     *         if (newThr == 0) {
     *             float ft = (float)newCap * loadFactor;
     *             newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
     *                       (int)ft : Integer.MAX_VALUE);
     *         }
     *         threshold = newThr;
     *         @SuppressWarnings({"rawtypes","unchecked"})
     *         Node<K, V>[] newTab = (Node<K,V>[])new Node[newCap];
     *         table = newTab;
     *         if (oldTab != null) {
     *             for (int j = 0; j < oldCap; ++j) {
     *                 Node<K,V> e;
     *                 if ((e = oldTab[j]) != null) {
     *                     oldTab[j] = null;
     *                     if (e.next == null)
     *                         newTab[e.hash & (newCap - 1)] = e;
     *                     else if (e instanceof TreeNode)
     *                         ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
     *                     else { // preserve order
     *                         Node<K,V> loHead = null, loTail = null;
     *                         Node<K,V> hiHead = null, hiTail = null;
     *                         Node<K,V> next;
     *                         do {
     *                             next = e.next;
     *                             if ((e.hash & oldCap) == 0) {
     *                                 if (loTail == null)
     *                                     loHead = e;
     *                                 else
     *                                     loTail.next = e;
     *                                 loTail = e;
     *                             }
     *                             else {
     *                                 if (hiTail == null)
     *                                     hiHead = e;
     *                                 else
     *                                     hiTail.next = e;
     *                                 hiTail = e;
     *                             }
     *                         } while ((e = next) != null);
     *                         if (loTail != null) {
     *                             loTail.next = null;
     *                             newTab[j] = loHead;
     *                         }
     *                         if (hiTail != null) {
     *                             hiTail.next = null;
     *                             newTab[j + oldCap] = hiHead;
     *                         }
     *                     }
     *                 }
     *             }
     *         }
     *         return newTab;
     *     }
         */
        hashSet.add("php");
        /**
         * 第二次添加元素
         * public boolean add(E e) {
     *         return map.put(e, PRESENT)==null;
     *     }
         * public V put(K key, V value) {
     *         return putVal(hash(key), key, value, false, true);
     *     }
         * static final int hash(Object key) {
     *         int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     *     }
         *final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
     *         if ((tab = table) == null || (n = tab.length) == 0)
     *             n = (tab = resize()).length;
     *         if ((p = tab[i = (n - 1) & hash]) == null)
     *             tab[i] = newNode(hash, key, value, null);
     *         else {
     *             Node<K,V> e; K k;
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
     *                 e = p;
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
     *                 for (int binCount = 0; ; ++binCount) {
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     p = e;
     *                 }
     *             }
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
     *         if (++size > threshold)
     *             resize();
     *         afterNodeInsertion(evict);
     *         return null;
     *     }
         */
        hashSet.add("java");
        /**
         * 添加一个重复的元素（不再进行上述分析的步骤，直接看putVal方法)
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
     *         if ((tab = table) == null || (n = tab.length) == 0)
     *             n = (tab = resize()).length;
     *         if ((p = tab[i = (n - 1) & hash]) == null)
     *             tab[i] = newNode(hash, key, value, null);
     *         else {
         *         //辅助变量
     *             Node<K,V> e; K k;
         *         //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值相同且p中的key和准备添加的key是同一个对象（对引用类型来说）或者值相同（对基本类型来说）
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
         *             //e也指向p，不能加入
     *                 e = p;
         *         //如果上述条件不满足。判断p是否一个红黑树，如果是一颗红黑树，就按照红黑树的方法添加
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
         *         //如果上述条件也不满足，因为p指向的是头节点，从头节点开始往后依次遍历，如果找到元素已经存在了，就不添加
         *         //否则就将新元素添加到链表的最尾部。
         *         //如果添加后，链表的长度 >= 阈值 8，就将当前的这条链表，进行红黑树变换。注意，在进行红黑树变换时，还需要
         *         //判断hash表的长度是否超过了最大阈值64，如果没有超过，只是进行扩容操作，而不是树化操作，它认为扩容操作也
         *         //可以解决hash碰撞。
         *         //if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
         *         //    resize();
         *
     *                 for (int binCount = 0; ; ++binCount) {
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     p = e;
     *                 }
     *             }
         *         //如果e不为空，就证明元素已经存在，返回存在的元素
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
     *         if (++size > threshold)
     *             resize();
     *         afterNodeInsertion(evict);
     *         return null;
     *     }
         *
         */
        System.out.println("set=" + hashSet);
    }
}
