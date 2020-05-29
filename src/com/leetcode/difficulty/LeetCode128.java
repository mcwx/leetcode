package com.leetcode.difficulty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:最长连续序列 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/29
 */
public class LeetCode128 {

    public static void main(String[] args) {
        longestConsecutive(new int[]{1, 2, 0, 1});
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int longestCount = 1;
        int currLongestCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                currLongestCount++;
            } else {
                longestCount = Math.max(longestCount, currLongestCount);
                currLongestCount = 1;
            }
        }
        return Math.max(longestCount, currLongestCount);
    }

    public static int longestConsecutive_01(int[] nums) {
        if (nums == null)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longestCount = 0;
        int currNum;
        int currLongestCount;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                currNum = num;
                currLongestCount = 1;
                while (set.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    currLongestCount = currLongestCount + 1;
                }
                longestCount = Math.max(longestCount, currLongestCount);
            }
        }
        return longestCount;
    }

}
