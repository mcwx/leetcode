package com.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Description:
 * @Auther: houpeng
 * @Date: 2020/4/29
 */
public class LeetCode119 {

    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> resultRowList = new ArrayList<>();
        if (rowIndex == 0) {
            resultRowList.add(1);
            return resultRowList;
        }

        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            resultRowList = new ArrayList<>();
            resultRowList.add(1);
            for (int j = 1; j < i; j++) {
                resultRowList.add(preRow.get(j - 1) + preRow.get(j));
            }
            resultRowList.add(1);
            preRow = resultRowList;
        }
        return resultRowList;
    }
}
