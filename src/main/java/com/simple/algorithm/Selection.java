package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/12 14:42:54
 */
public class Selection {
    // 简单选择排序
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3};
        selectionSort(a);
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            // 找到最小值的【位置】
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 交换值
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
