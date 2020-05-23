package com.leetcode.medium;

/**
 * @Description:寻找旋转排序数组中的最小值 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/23
 */
public class LeetCode153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,1}));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] >= nums[left]) {
            return nums[0];
        }
        while (left < right) {
            int mid = left - (left - right) / 2;
            if (nums[mid] >= nums[0]) {//最小值只能在[mid+1,right],mid + 1
                left = mid + 1;
            } else {//最小值只能在[left,mid]// mid
                right = mid;
            }
        }
        return nums[left];
    }
}
