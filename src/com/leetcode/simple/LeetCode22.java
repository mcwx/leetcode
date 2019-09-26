package com.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:    括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-26
 */
public class LeetCode22 {

    public static void main(String[] args) {
        generateParenthesis(3);
    }


    /**
     * 递归，剪枝
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, result, "");
        return result;
    }

    public static void helper(int left, int right, int n, List<String> list, String s) {
        if (left == n && right == n) {
            list.add(s);
        }
        if (left < n) {
            helper(left + 1, right, n, list, s.concat("("));
        }
        if (right < left && right < n) {
            helper(left, right + 1, n, list, s.concat(")"));
        }
    }

}
