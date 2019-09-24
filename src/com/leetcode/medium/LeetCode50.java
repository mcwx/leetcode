package com.leetcode.medium;

/**
 * @Description:    Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 0.00001
 * 2147483647
 * @Auther: houpeng
 * @Date: 2019-09-23
 */
public class LeetCode50 {


    public static void main(String[] args) {
        System.out.println(myPow1(2.00000, 10));
    }

    /**
     * 递归法，注意n为-2的32²的时候，符号转换需要将n由int换为long
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public static double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            x = half * half;
        } else {
            x = x * half * half;
        }
        return x;
    }

    /**
     * 循环法
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double currentResult = x;
        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                result = result * currentResult;
            }
            currentResult = currentResult * currentResult;
        }
        return result;
    }
}
