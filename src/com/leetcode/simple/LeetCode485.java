package com.leetcode.simple;

import java.util.TreeSet;

/**
 * @Description:最大连续1的个数 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/2
 */
public class LeetCode485 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int nums[]) {

        int preCount = 0;
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
            } else if (nums[i] == 0 || curCount != 0) {
                preCount = Math.max(preCount, curCount);
                curCount = 0;
            }
        }

        return Math.max(preCount, curCount);
    }
}
