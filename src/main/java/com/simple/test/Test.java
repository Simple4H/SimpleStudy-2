package com.simple.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create By S I M P L E On 2018/11/21 15:17:50
 */

@Slf4j
public class Test {

    // list去重，list与set转换
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(12);
        list.add(13);
        list.add(15);
        list.add(15);
        list.add(29);
        list.add(19);
        log.error("before list is :{}",list);
        Set<Integer> set = new HashSet();
        set.addAll(list);
        List newList = new ArrayList();
        newList.add(set);
        log.error("after list is :{}",newList);

    }
}
