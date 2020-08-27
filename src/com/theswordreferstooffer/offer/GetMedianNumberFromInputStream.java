package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianNumberFromInputStream {
//    private ArrayList<Double> arrayList = new ArrayList<>();
//    public void Insert(Integer num) {
//        arrayList.add((double)num);
//    }
//
//    public Double GetMedian() {
//        Collections.sort(arrayList);
//        int size = arrayList.size();
//        double result;
//        if(size % 2 == 0){
//            result = (arrayList.get(size/2) + arrayList.get(size/2 - 1)) / 2;
//        }
//        else{
//            result = arrayList.get(size/2);
//        }
//        return result;
//    }

    //书中解法

    /**
     * 创建优先级队列维护大顶堆和小顶堆两个堆，并且小顶堆的值都大于大顶堆的值，
     * 2个堆个数的差值小于等于 1，所以当插入个数为奇数时：大顶堆个数就 比小顶堆多 1，
     * 中位数就是大顶堆堆头；当插入个数为偶数时，使大顶堆个数跟小 顶堆个数一样，中位数就是 2个堆堆头平均数。
     * 也可使用集合类的排序方法
     * @param num
     */
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count ++;
        //当数据个数为奇数时，进入大根堆
        if((count & 1) == 1){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if(count == 0){
            return null;
        }
        if((count & 1) == 1){
            return Double.valueOf(maxHeap.peek());
        }
        else{
            return (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) / 2;
        }
    }
}
