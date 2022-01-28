package com.underlying;

import java.util.HashMap;

public class HashMapUnderlying {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        /**
         * //1.构造器，注意，构造器里面只是初始化了加载因子，并没有实际开辟空间
         * // HashMap$Node[] table = null
         * public HashMap() {
     *         this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted 0.75
     *     }
         *
         */
        hashMap.put("java",10);
        /**
         * //2.执行put方法
         * public V put(K key, V value) { //key = "java" value = 10
     *         return putVal(hash(key), key, value, false, true);
     *     }
         * //3.调用hash(key) 计算key的hash值
         * static final int hash(Object key) {
     *         int h;
     *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     *     }
         * //4.执行putVal
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
     *         Node<K,V>[] tab; Node<K,V> p; int n, i;
         *     //如果table为null或者table的长度为0
     *         if ((tab = table) == null || (n = tab.length) == 0)
         *         //执行resize()方法并返回长度
     *             n = (tab = resize()).length;
         *     //通过传入的hash值和table的长度做与运算，计算传入的值应该放在的位置
     *         if ((p = tab[i = (n - 1) & hash]) == null)
         *         //如果计算得到的数组（桶）的第一个元素是空的，那么就把创建一个新的Node,把key-value传进去，挂到桶的第一个位置。
     *             tab[i] = newNode(hash, key, value, null);
     *         else {
         *         //否则，（也就是计算得到的要插入的桶，该桶的第一个元素不为null)
     *             Node<K,V> e; K k;
         *         //先和桶的头节点比较
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
         *             //如果，桶的头节点的hash值和计算出来得到的hash相同，头节点的key和传入的key值相同(基本数据类型)或引用相同(引用类型)
         *             //将头节点p的值赋值给e。 e是要返回的。
     *                 e = p;
     *             else if (p instanceof TreeNode)
         *             //否则，如果这个p是一个树节点，即hashmap已经红黑树化了。进行红黑树的判断
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
         *             //否则，即与头节点不相同。开始向后遍历
     *                 for (int binCount = 0; ; ++binCount) {
         *                 //如果桶的头节点的下一个节点，即p.next为空。
     *                     if ((e = p.next) == null) {
         *                     //直接创建新的Node，将值传入，挂上去
     *                         p.next = newNode(hash, key, value, null);
         *                     //挂完之后，还要判断，该桶的大小是不是已经到了可以树化的阈值(8)
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                         //如果是，则判断是否要树化。树化必须达到，桶的个数为64个，且有一个桶内的元素数量超过了阈值8
         *                         //这里需要注意的是，并不是一个桶中只能装阈值(8)个元素。如果超过了阈值，进行了扩容，但是经
         *                         //计算之后，还是要插入扩容后的那个桶中，就依然往那个桶中添加元素，这时那个桶中就有了9个元素，
         *                         //table中的桶的数量也进行了翻倍，扩容了，到达了32。同理，如果经计算后还是向那个桶中插入元素。
         *                         //桶中元素到达了10，table中桶数量翻倍，达到了64。同理，如果经计算后还是向那个桶中插入元素.
         *                         //桶中元素达到了11个，但是这时候，不能扩容了，就进行树化！！
         *                         //如果没有达到条件，就先暂时扩容，不进行树化。
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
         *                 //如果桶的头节点的下一个不为空，那么将头节点的下一个节点的hash值，key等做同样的比较。
         *
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *                     //如果相同，直接break
     *                         break;
         *                 //否则，继续向后遍历
     *                     p = e;
     *                 }
     *             }
         *         //如果走到了这一步，就证明在某个桶中，已经存在了某个node的key和传入的key相同
         *         //直白一点就是，已经有该节点了
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
         *             //如果没有设置"只有不存在再插入，已经有了就不更新"这个条件。或者该节点的value本身就是null
     *                 if (!onlyIfAbsent || oldValue == null)
         *                 //执行更新
     *                     e.value = value;
     *                 afterNodeAccess(e);
         *             //返回该节点原来的value值。
     *                 return oldValue;
     *             }
     *         }
     *         ++modCount;
     *         if (++size > threshold)
         *         //如果添加该元素之后，table的长度比阈值大，那么扩容
     *             resize();
     *         afterNodeInsertion(evict);
     *         return null;
     *     }
         * //5.执行resize()方法
         * final Node<K,V>[] resize() {
         *     //创建一个临时遍历oldTab指向table
     *         Node<K,V>[] oldTab = table;
         *     //记录table原来的长度，如果table为空，则置为0，否则获取原来的table长度
     *         int oldCap = (oldTab == null) ? 0 : oldTab.length;
         *     //创建一个临时遍历oldThr，值为原来的threshold
     *         int oldThr = threshold;
     *         int newCap, newThr = 0;
     *         if (oldCap > 0) {
         *         //如果table原来的长度>=最大容量
     *             if (oldCap >= MAXIMUM_CAPACITY) {
         *             //那么threshold变为Integer.MAX_VALUE
     *                 threshold = Integer.MAX_VALUE;
         *             //不扩容，直接返回原来的table
     *                 return oldTab;
     *             }
     *             else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
     *                      oldCap >= DEFAULT_INITIAL_CAPACITY)
         *             //如果原来的table的长度 * 2比最大长度小，且原来的长度>=初始长度(16)
         *             //新的阈值在旧阈值的基础上翻倍
     *                 newThr = oldThr << 1; // double threshold
     *         }
     *         else if (oldThr > 0) // initial capacity was placed in threshold
         *         //否则，如果旧的阈值 > 0
         *         //新的容量 = 旧的阈值
     *             newCap = oldThr;
     *         else {               // zero initial threshold signifies using defaults
         *         //否则
         *         //新的容量等于默认初始容量(16),也就是 oldCap = 0的情况
     *             newCap = DEFAULT_INITIAL_CAPACITY;
         *         //新的阈值 = 默认装载因子0.75 * 默认初始容量 16
     *             newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
     *         }
     *         if (newThr == 0) {
     *             float ft = (float)newCap * loadFactor;
     *             newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
     *                       (int)ft : Integer.MAX_VALUE);
     *         }
     *         threshold = newThr;
     *         @SuppressWarnings({"rawtypes","unchecked"})
         *     //根据计算出的容量，重新创建一个Node数组
     *         Node<K, V>[] newTab = (Node<K,V>[])new Node[newCap];
     *         table = newTab;
         *     //如果原来的数组不为空
     *         if (oldTab != null) {
         *         //下面的代码是核心代码，将原来的数据，移动到新的数组中
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
         *
         */
        hashMap.put("php",10);
        hashMap.put("java",20);
        System.out.println("map = " + hashMap);
    }
}
