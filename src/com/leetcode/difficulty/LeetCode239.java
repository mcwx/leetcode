package com.leetcode.difficulty;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Description:给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-04
 */
public class LeetCode239 {

    public static void main(String[] args) {
        int[] result = maxSlidingWindow1(new int[]{7, 2, 4}, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 暴力破解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length * k == 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int max;
        for (int i = 0; i < nums.length - k + 1; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            result[i] = max;
        }
        return result;
    }

    /**
     * 最大堆法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(nums.length - k + 1, (o1, o2) -> o2 - o1);

        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                maxQueue.offer(nums[j]);
            }
            result[i] = maxQueue.peek();
            maxQueue.clear();
        }
        return result;
    }

    /**
     * 双端队列法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            if(deque.isEmpty()){
                deque.offer(nums[i]);
                max = nums[i];
            }else{
                if(nums[i] > max){
                    max = nums[i];
                }
            }
            if(i>=k){
                result[i-k] = max;
            }
        }
        return result;

    }
}
