package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/15 10:57:14
 */
public class QuickSort {
    // 快速排序
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 9, 10, 3, 1};
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 基准值key
            int key = array[low];
            int start = low;
            int end = high;
            // 如果左下标小于右下标，则执行。直到两个下角标相遇
            while (start < end) {
                // 左下标小于数组长度且该下标的值小于key，直到首个下标值大于key的值（下标从左往右）
                while (start < high && array[start] < key)
                    start++;
                // 右下标大于数组长度且该下标的值大于key，直到首个下标值小于key的值（下标从右往左）
                while (end > low && array[end] > key)
                    end--;
                // 将跳出循环的两个值转换位置，两个下角标继续移动
                if (start <= end) {
                    int temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    end--;
                    System.out.println(Arrays.toString(array));
                }
            }
            // 这里不断的递归，直到数组只有一个元素
            // 右下标大于0，递归调用。同时，将右下标作为递归终点
            if (low < end) {
                quickSort(array, low, end);
            }
            // 左下标小于数组的长度，递归调用。将start作为递归的起点
            if (high > start) {
                quickSort(array, start, high);
            }
        }
    }
}
