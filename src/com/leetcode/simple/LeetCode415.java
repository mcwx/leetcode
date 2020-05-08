package com.leetcode.simple;

/**
 * @Description:字符串相加 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/7
 */
public class LeetCode415 {
    public static void main(String[] args) {
        System.out.println(addStrings("9","99"));
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int n1, n2;
        int carry = 0;
        while ((p1 >= 0 || p2 >= 0) || carry != 0) {
            n1 = (p1 < 0) ? 0 : num1.charAt(p1) - '0';
            n2 = (p2 < 0) ? 0 : num2.charAt(p2) - '0';
            sb.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
            p1--;
            p2--;
        }
        return sb.reverse().toString();
    }
}
