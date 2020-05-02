package com.leetcode.simple;

/**
 * @Description:斐波那契数 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/2
 */
public class LeetCode509 {
    /**
     * 递归
     *
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public static int fib_01(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int[] nums = new int[N + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[N];
    }
}
