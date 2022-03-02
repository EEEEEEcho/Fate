package com.code.topOnehundred;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    //最朴素的方法
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    private Random random = new Random(System.currentTimeMillis());
    //利用快排的思路,需要使用随机数，来解决逆序数组等特殊情况,其实就是快排中的随机化处理
    public int findKthLargest2(int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;
        //第k个最大的元素，代表快排中，要插入到的第N - K个元素
        int target = nums.length - k;
        while (true){
            int partition = partition(nums,left,right);
            //要插入的元素的位置小于快排中探测到的插入的位置
            if (target < partition){
                right = partition - 1;
            }
            else if (target > partition){
                left = partition + 1;
            }
            else {
                return nums[partition];
            }
        }
    }
    public int partition(int[] nums,int left,int right){
        if (right == left){
            return right;
        }
        if (right > left){
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums,left,randomIndex);
        }
        int t = nums[left];
        int i = left;
        int j = right + 1;
        while (true){
            while (nums[++ i] < t){
                if (i == right) break;
            }
            while (t < nums[-- j]){
                if (j == left) break;
            }
            if (i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //堆实现,想找第K大的元素，只要构造一个维护了K个最大元素的堆即可
    public int findKthLargest3(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums){
            if (pq.size() == k){
                Integer top = pq.peek();
                if (num >= top){
                    pq.poll();
                    pq.offer(num);
                }
            }
            else{
                pq.offer(num);
            }
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int kthLargest2 = f.findKthLargest2(new int[]{1}, 1);
        System.out.println(kthLargest2);
    }
}
