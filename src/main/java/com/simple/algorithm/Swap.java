package com.simple.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * Create By S I M P L E On 2018/09/25 17:32:18
 */
@Slf4j
public class Swap {

    // 交换两个值
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int a = 1;
        int b = 2;
        log.warn("a:{},b:{}", a, b);
        swap2(a, b);
        log.warn("a:{},b:{}", a, b);
    }

    // 错误的示范
    private static void swap1(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

    // 正确的示范
    private static void swap2(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        int temp = a;
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(a, b);
        value.set(b, new Integer(temp));
    }
}
