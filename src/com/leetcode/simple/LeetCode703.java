package com.leetcode.simple;

import java.util.PriorityQueue;

/**
 * @Description:设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-03
 */
public class LeetCode703 {

    class KthLargest {
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int a : nums) {
                add(a);
            }
        }

        public int add(int val) {
            if (q.size() < k) {
                q.offer(val);
            } else if (q.peek() < val) {
                q.poll();
                q.offer(val);
            }
            return q.peek();
        }
    }
}
