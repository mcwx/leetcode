package com.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description:    求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-24
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int flag = map.getOrDefault(num, 0) + 1;
            if(flag > nums.length/2){
                return num;
            }
            map.put(num, flag);
        }
        return 0;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int flag = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == flag) {
                count++;
            } else {
                flag = num;
                count = 1;
            }
            if (count > nums.length) {
                return num;
            }
        }
        return 0;
    }
}
