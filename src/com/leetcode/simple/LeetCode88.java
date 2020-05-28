package com.leetcode.simple;

import java.util.Arrays;

/**
 * @Description:合并两个有序数组 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/4/29
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 6};
        merge_01(nums1, 3, nums2, 3);

        for (int v : nums1) {
            System.out.print(v);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums1 = Arrays.copyOf(nums1, m);
        int j = 0, k = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (j <= m - 1 && k <= n - 1) {
                if (tempNums1[j] < nums2[k]) {
                    nums1[i] = tempNums1[j];
                    j++;
                } else {
                    nums1[i] = nums2[k];
                    k++;
                }
            } else if (j > m - 1 && k <= n - 1) {
                nums1[i] = nums2[k];
                k++;

            } else if (j <= m - 1 && k > n - 1) {
                nums1[i] = tempNums1[j];
                j++;
            }
        }
    }

    public static void merge_01(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
