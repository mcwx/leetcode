package com.leetcode.simple;

/**
 * @Description:给定两个二进制字符串，返回他们的和（用二进制表示）。 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-07-23
 */
public class LeetCode67 {
    public static String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int addend_a = i < 0 ? 0 : a.charAt(i) - '0';
            int addend_b = j < 0 ? 0 : b.charAt(j) - '0';
            answer.append((addend_a + addend_b + carry) % 2);
            carry = (addend_a + addend_b + carry) / 2;
        }

        answer.append(carry == 1 ? carry : "");
        return answer.reverse().toString();
    }
}
