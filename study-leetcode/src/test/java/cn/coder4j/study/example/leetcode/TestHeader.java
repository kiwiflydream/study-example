/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author buhao
 * @version TestHeader.java, v 0.1 2021-01-03 23:29 buhao
 */
public class TestHeader {

    public static void main(String[] args) {
        List<Integer> headers = new ArrayList<>();
        headers.add(1);
        headers.add(2);
        headers.add(2);
        headers.add(1);
        headers.add(2);
        headers.add(3);
        headers.add(3);
        headers.add(3);

        Integer[] h = new Integer[]{0, 0, 0, 0, 0, 0};
        for (Integer header : headers) {
            final int curIndex = header - 1;
            h[curIndex]++;
            for (int i = header; i < h.length; i++) {
                h[i] = 0;
            }
            System.out.println(Arrays.stream(h).map(it -> it.toString()).collect(Collectors.joining(".")));
        }


    }

}