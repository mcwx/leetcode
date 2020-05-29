package com.leetcode.simple;

import java.util.Arrays;

/**
 * @Description:计数质数 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @Auther: houpeng
 * @Date: 2020/5/28
 */
public class LeetCode204 {

    public static void main(String[] args) {
        countPrimes(10);
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 偶数除了2肯定都不是质数
     *
     * @param n
     * @return
     */
    public static int countPrimes_01(int n) {
        if (n < 3) {
            return 0;
        } else if(n == 3){
            return 1;
        }
        int count = 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrimes_01(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes_02(int n) {
        boolean[] isPrim = new boolean[n];
        for (int i = 2; i * i < n; i++)
            if (!isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = true;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (!isPrim[i]) count++;

        return count;
    }

    private static boolean isPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化质数判断，because乘法交换律
     *
     * @param n
     * @return
     */
    private static boolean isPrimes_01(int n) {
        for (int i = 3; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
