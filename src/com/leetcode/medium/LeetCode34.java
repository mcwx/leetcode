package com.leetcode.medium;

import java.util.Arrays;

/**
 * @Description:在排序数组中查找元素的第一个和最后一个位置 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/23
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {// nums[mid] == target(左右两侧分别二分)
                //左侧二分求得left
                left = leftHelper(left, mid, nums, target);
                ans[0] = left;
                //右侧二分求得right
                right = rightHelper(mid, right, nums, target);
                ans[1] = right;
                return ans;
            }
        }
        return ans;
    }

    private int leftHelper(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private int rightHelper(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}
