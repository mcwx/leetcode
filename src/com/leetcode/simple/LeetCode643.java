package com.leetcode.simple;


/**
 * @Description: 子数组最大平均数 I
 * <p>
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/4
 */
public class LeetCode643 {

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        System.out.println(findMaxAverage(nums, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int[] tmpNums = new int[nums.length];
        tmpNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmpNums[i] = nums[i] + tmpNums[i - 1];
        }
        int max = tmpNums[k-1];
        for (int i = k; i < tmpNums.length; i++) {
            max = Math.max(max, tmpNums[i] - tmpNums[i - k]);
        }
        return (double)max / k;
    }
}
