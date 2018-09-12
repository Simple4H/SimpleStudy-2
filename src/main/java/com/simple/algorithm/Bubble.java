package com.simple.algorithm;

import java.util.Arrays;

/**
 * Create By S I M P L E On 2018/09/12 15:18:11
 */
public class Bubble {
    // 冒泡排序
    public static void main(String[] args) {
        int[] a = {3, 6, 1, 4, 5, 3, 6, 7, 212, 23, 41, 3};
        bubbleSort(a);
    }

    private static void bubbleSort(int[] array){
        //外层循环移动游标
        for (int i = array.length - 1; i > 0; i--) {
            //内层循环遍历游标及之后(或之前)的元素
            for(int j = 0; j < i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(array));
                }
            }
        }
    }
}
