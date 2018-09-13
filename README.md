# SimpleStudy-2

## 常见的算法v1.0

​	看了许多的面试，都问到了有关算法的问题。然后上网找了一些。这位同学写的非常的不错，可以学一下。

[GitHub地址](https://github.com/iTimeTraveler/SortAl˚gorithms#%E4%BA%94%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8Fbubble-sort)认真学习和膜拜一下。概念之类的网上有很多，我就用自己的理解来写一写。

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