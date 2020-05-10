package com.leetcode.simple;

/**
 * @Description:字符串中的单词数 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/10
 */
public class LeetCode434 {

    public static void main(String[] args) {
        String s = "  a";
        System.out.println(countSegments_01(s));
    }

    public static int countSegments(String s) {
        if (s == null || s.isEmpty() || s.replaceAll(" ", "").isEmpty()) {
            return 0;
        }
        String sTrimed = s.trim();
        return sTrimed.split("\\s+").length;
    }

    public static int countSegments_01(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
