package com.leetcode.simple;

import java.util.Collections;
import java.util.HashSet;

/**
 * @Description:只出现一次的数字 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/23
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber_01(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public int singleNumber_02(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sumTotal = 0;
        int sumSet = 0;
        for (int num : nums) {
            sumTotal += num;
            if (set.add(num)) {
                sumSet += num;
            }
        }
        return sumSet * 2 - sumTotal;
    }
}
