package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/12 14:04:37
 */
// 直接插入排序
public class Insertion {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3};
        insertionSort(a);
    }


    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 取数组的第【二】个值
            int temp = array[i];
            // 从后往前，依次判断前面一个数是不是大于本身
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j - 1] > temp) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = temp;
                    // 这里一定要跳出循环
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
