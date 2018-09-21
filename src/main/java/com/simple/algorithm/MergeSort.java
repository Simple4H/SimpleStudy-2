package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/20 14:17:02
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a1 = {1, 3, 6, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3, 212};
        int[] a2 = {1, 3, 6, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3, 212};
        mergeSort1(a1);
        System.out.println("递归：" + Arrays.toString(a1));
        mergeSort2(a2);
        System.out.println("迭代：" + Arrays.toString(a2));
    }

    // 递归版
    private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start;
        int start2 = mid + 1;
        merge_sort_recursive(arr, result, start1, mid);
        merge_sort_recursive(arr, result, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid)
            result[k++] = arr[start1++];
        while (start2 <= end)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    private static void mergeSort1(int[] array) {
        int len = array.length;
        int[] result = new int[len];
        merge_sort_recursive(array, result, 0, len - 1);
    }

    // 迭代版
    @SuppressWarnings("ConstantConditions")
    private static void mergeSort2(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }
}
