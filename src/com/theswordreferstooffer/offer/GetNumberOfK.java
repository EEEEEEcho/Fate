package com.theswordreferstooffer.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    /**
     * 提示了有序，用二分,先找一个中间位置，然后再在其范围内搜索。，
     * 尽量降低时间复杂度
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = array.length;
        int range = 0;
        while (left < right){
            int mid = (left + right) / 2;
            if(array[mid] == k){
                range = mid;
                break;
            }
            else if(array[mid] > k){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        for(int i=range;i < array.length;i ++){
            if(array[i] == k){
                count ++;
            }
            else {
                break;
            }
        }
        for (int i = range - 1;i >=0; i--){
            if(array[i] == k){
                count ++;
            }
            else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GetNumberOfK g = new GetNumberOfK();
        int array[] = new int[]{1,2,2,3,4};
        int res = g.getNumberOfK(array,2);
        System.out.println(res);
    }
}
