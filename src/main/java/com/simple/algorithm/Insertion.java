package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/12 14:04:37
 */
public class Insertion {
    // 直接插入排序
    public static void main(String[] args) {
        int[] a = {3, 1, 211, 4, 5, 3, 6, 7, 212, 23, 41, 3};
        insertionSort(a);
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 取数组的第【二】个值
            int temp = array[i];
            // 从i开始，判断前面一个值是否大于本身
            for (int j = i; j >= 0; j--) {
                // 需要temp，因为相同下标，但是其中的值会改变。
                // j > 0 防止数组越界。当j = 0，j - 1是没有值的。
                if (j > 0 && array[j - 1] > temp) {
                    // 我的理解：当j-1比temp大的值，将j【覆盖】。
                    // 当循环到j次，没有比temp大的值，将temp赋值给array[j]
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
