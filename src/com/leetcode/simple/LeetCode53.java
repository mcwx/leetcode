package com.leetcode.simple;

/**
 * @Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: 漫长玩笑
 * @Date: 2019-06-24
 */
public class LeetCode53 {
    public static int maxSubArray(int[] nums) {
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndHere = max(nums[i], maxEndHere + nums[i]);
            maxSoFar = max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }

    private static int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }
}
