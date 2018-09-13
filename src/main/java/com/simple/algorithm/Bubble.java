package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/12 15:18:11
 */
public class Bubble {
    // 冒泡排序
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3, 212};
        bubbleSort2(a);
    }

    private static void bubbleSort2(int[] array) {
        // 外层总共需要循环【数组长度】次
        for (int i = 0; i < array.length; i++) {
            // 从后往前
            // 这里我的理解：经过一轮的冒泡排序后，最大数都是在最右边。不知道有没有想错。
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Sorting: " + Arrays.toString(array));
    }
}
