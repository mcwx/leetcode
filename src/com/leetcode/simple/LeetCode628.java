package com.leetcode.simple;

import java.util.Arrays;

/**
 * @Description:三个数的最大乘积 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/4
 */
public class LeetCode628 {

    public static void main(String[] args) {
        int[] nums = new int[]{1000,1000,1000};
        System.out.println(maximumProduct_01(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static int maximumProduct_01(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num > max2) {
                max1 = max2;
                max2 = num;
            } else if (num > max1) {
                max1 = num;
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}
