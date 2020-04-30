package com.leetcode.simple;

/**
 * @Description:移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/4/30
 */
public class LeetCode283 {
    /**
     * 自我思考(快慢指针)
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p] = nums[i];
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 快速排序，以0为交换点
     * @param nums
     */
    public static void moveZeroes_1(int[] nums) {
        if (nums == null) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }
    }
}
