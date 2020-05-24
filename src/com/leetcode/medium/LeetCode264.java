package com.leetcode.medium;

import com.leetcode.simple.LeetCode263;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Description:丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/24
 */
public class LeetCode264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber_01(1352));
    }

    /**
     * 从1开始验证，知道第n个丑数
     * 这种方法会超时的
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int i = 0;
        int start = 1;
        while (i < n) {
            if (LeetCode263.isUgly(start)) {
                i++;
            }
            start++;
        }
        return --start;
    }


    /**
     * 计算第n个丑数
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber_01(int n) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> head = new PriorityQueue<>();
        head.add(1L);
        set.add(1L);
        int i = 0;
        long currNum = -1L;
        while (i < n) {
            currNum = head.poll();
            i++;
            if (!set.contains(currNum * 2)) {
                head.add(currNum * 2);
                set.add(currNum * 2);
            }
            if (!set.contains(currNum * 3)) {
                head.add(currNum * 3);
                set.add(currNum * 3);
            }
            if (!set.contains(currNum * 5)) {
                head.add(currNum * 5);
                set.add(currNum * 5);
            }
        }
        return (int) currNum;
    }
}
