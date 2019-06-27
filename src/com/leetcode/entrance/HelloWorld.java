package com.leetcode.entrance;

import com.leetcode.simple.LeetCode35;
import com.leetcode.simple.LeetCode38;
import com.leetcode.simple.LeetCode53;


/**
 * @Description:算法校验入口
 * @Auther: 漫长玩笑
 * @Date: 2019-06-26
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Welcome to leetCode world!");
        try {
            System.out.println(LeetCode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
            System.out.println(LeetCode38.countAndSay(10));
            System.out.println(LeetCode35.searchInsert(new int[]{1, 3, 5, 6}, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
