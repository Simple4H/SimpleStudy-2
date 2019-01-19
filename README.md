# SimpleStudy-2

## 常见的算法v1.0

​	看了许多的面试，都问到了有关算法的问题。然后上网找了一些。这位同学写的非常的不错，学习一下。

[GitHub地址](https://github.com/iTimeTraveler/SortAlgorithms)认真学习和膜拜一下。概念之类的网上有很多，我就用自己的理解来写一写。

### 简单选择排序

​	选择排序，先遍历循环取得数组最小值的下标。然后判断该下标值是否与当前下标值相同。如果不相同，则交换两个的值。

```java
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
            // 找到最小值的下标
            for (int j = i + 1; j < array.length; j++) {
                // 与数组剩下的值进行比较
                // 剩下的值 = 数组长度-当前数组的下标
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
```

### 冒泡排序

​	冒泡排序，n与n+1进行比较，将较大的数字放在右边。经过1轮后，最大数便在最右边。以此类推。

```java
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
```

### 插入排序

​	插入排序就是将第n个元素与n以前的元素进行比较，插入到首个比他小的数前面。需要注意的是，与插入排序不同的是：插入排序，取得是值，不是下标。（？）

```java
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
                    // 我的理解：当j-1比temp大的，则将j【覆盖】（移动至下一位置）。
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
```

### 快速排序

​	快速排序：先找个基准数（我喜欢我array[0]），左边寻找第一个比其大的数，右边寻找第一个比其小的数。然后交换两个的值。依次递归。直到【子数组】长度为1。（不知道这里理解没有错误）

```java
public class QuickSort {
    // 快速排序
    public static void main(String[] args) {
        int[] a = {5, 6, 1, 9, 10, 3, 1};
        quickSort2(a, 0, a.length - 1);
    }

    private static void quickSort2(int[] array, int low, int high) {
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
                quickSort2(array, low, end);
            }
            // 左下标小于数组的长度，递归调用。将start作为递归的起点
            if (high > start) {
                quickSort2(array, start, high);
            }
        }
    }
}
```

Todo:堆排序

Todo:归并排序

Todo:支付宝

Todo:科三Yes