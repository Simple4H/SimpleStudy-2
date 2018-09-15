package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/15 10:57:14
 */
public class QuickSort {
    // 快速排序
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 211, 4, 5, 3, 2, 6, 7, 212, 23, 41, 3};
        quickSort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort2(int[] array, int low, int high) {
        if (low < high) {
            int key = array[low];
            int start = low;
            int end = high;
            while (start <= end) {
                while (start < high && array[start] < key)
                    start++;
                while (end > low && array[end] > key)
                    end--;
                if (start <= end) {
                    int temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    end--;
                }
            }
            if (low < end) {
                quickSort2(array, low, end);
            }
            if (high > start) {
                quickSort2(array, start, high);
            }
        }
    }
}
