package com.leetcode.entrance;

import static com.leetcode.simple.LeetCode53.maxSubArray;

/**
 * @Description:算法校验入口
 * @Auther: 漫长玩笑
 * @Date: 2019-06-26
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to leetCode world!");
        try {
            System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
