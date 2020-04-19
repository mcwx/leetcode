package com.leetcode.simple;

/**
 * @Description:爬楼梯 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/4/17
 */
public class LeetCode70 {
    /**
     * 暴力法
     * 时间复杂度O(2^n)
     * 空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 斐波那契数列公式法
     * <p>
     * https://dss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2524561525,4505879&fm=58
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        return (int) ((Math.pow((1 + Math.sqrt(new Double(5))) / 2, n + 1) - Math.pow((1 - Math.sqrt(new Double(5))) / 2, n + 1)) / Math.sqrt(new Double(5)));
    }

    /**
     * 斐波那契数列推理法
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }

    /**
     * 记忆递归法
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        int[] memo = new int[n];
        int i = climbStairsHelper(n, memo);
        System.out.println(i);

        return climbStairsHelper(n, memo);
    }

    public int climbStairsHelper(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n - 2] > 0) {
            return memo[n];
        }
        int i = climbStairsHelper(n - 1, memo);
        memo[n - 1] = i;
        int j = climbStairsHelper(n - 2, memo);
        memo[n - 2] = j;
        return i + j;
    }


    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        long startTime = System.currentTimeMillis();
        System.out.println("LeetCode70.main=" + leetCode70.climbStairs3(45));
        System.out.println("use time = " + (System.currentTimeMillis() - startTime));
    }
}
