package com.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/4/29
 */
public class LeetCode118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currLevel = new ArrayList<>();
            currLevel.add(1);
            List<Integer> preLevel = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                currLevel.add(preLevel.get(j - 1) + preLevel.get(j));
            }
            result.add(currLevel);
            currLevel.add(1);
        }
        return result;
    }
}
