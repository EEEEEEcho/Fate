package com.underlying;

import java.util.Hashtable;

public class HashTableUnderlying {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("john",100);
        hashtable.put("lucy",100);
        hashtable.put("lic",100);
        hashtable.put("lic",88);
        System.out.println(hashtable);
        /**
         * Hashtable底层
         * //1.底层有数组 Hashtable$Entry[] 初始化大小为11
         * //2.临界值 threshold 8  = 11 * 0.75
         * //3.键和值都不可以为null
         * //4.执行方法 addEntry(hash, key, value, index); 将key和value封装到Entry中
         * //5.扩容方法
         * protected void rehash() {
         *         int oldCapacity = table.length;
         *         Entry<?,?>[] oldMap = table;
         *
         *         // overflow-conscious code
         *         //新的容量为旧容量 * 2 + 1
         *         int newCapacity = (oldCapacity << 1) + 1;
         *         if (newCapacity - MAX_ARRAY_SIZE > 0) {
         *             if (oldCapacity == MAX_ARRAY_SIZE)
         *                 // Keep running with MAX_ARRAY_SIZE buckets
         *                 return;
         *             newCapacity = MAX_ARRAY_SIZE;
         *         }
         *         Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];
         *
         *         modCount++;
         *         threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
         *         table = newMap;
         *
         *         for (int i = oldCapacity ; i-- > 0 ;) {
         *             for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {
         *                 Entry<K,V> e = old;
         *                 old = old.next;
         *
         *                 int index = (e.hash & 0x7FFFFFFF) % newCapacity;
         *                 e.next = (Entry<K,V>)newMap[index];
         *                 newMap[index] = e;
         *             }
         *         }
         *     }
         */
    }
}
