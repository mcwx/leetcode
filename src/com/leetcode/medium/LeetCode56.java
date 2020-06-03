package com.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/4/16
 */
public class LeetCode56 {

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();

//        int[] testArr = {1, 2, 58, 8, 9, 61, 2};
//        Arrays.sort(testArr);
//        System.out.println(Arrays.toString(testArr));
//        String[] sArr = new String[]{"a", "b"};
//        Arrays.sort(sArr, Collections.reverseOrder());
//        System.out.println(Arrays.toString(sArr));
//        System.out.println(Arrays.toString(testArr));


        int[][] testData = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = leetCode56.merge_01(testData);
        System.out.println(Arrays.toString(ints));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return intervals;
        }
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            int j;
            for (j = i; j > 0; j--) {
                if (tmp[0] < intervals[j - 1][0]) {
                    intervals[j] = intervals[j - 1];
                } else {
                    break;
                }
            }
            intervals[j] = tmp;
        }
        int[][] tempArray = new int[intervals.length][2];
        tempArray[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= tempArray[j][1]) {
                continue;
            } else if (intervals[i][0] > tempArray[j][1]) {
                tempArray[j + 1] = intervals[i];
                j++;
            } else {
                tempArray[j][1] = intervals[i][1];
            }
        }
        int[][] resultArray = new int[j + 1][2];
        for (int i = 0; i < j + 1; i++) {
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }

    public int[][] merge_01(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > result[idx][1]) {
                result[++idx] = interval;
            } else {
                result[idx][1] = Math.max(result[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, idx + 1);
    }
}
