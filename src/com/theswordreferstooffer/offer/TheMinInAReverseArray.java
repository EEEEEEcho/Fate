package com.theswordreferstooffer.offer;

public class TheMinInAReverseArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }
        return 0;
    }

    /**
     * 采用二分法，查找一般都可以归结到二分
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1 || array[array.length - 1] > array[0]) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            }

            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，最左下标
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(array[mid] > array[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return array[left];
    }
    public static void main(String[] args) {

    }
}
