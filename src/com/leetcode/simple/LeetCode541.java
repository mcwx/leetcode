package com.leetcode.simple;

/**
 * @Description:反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * 提示：
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/17
 */
public class LeetCode541 {

    public static void main(String[] args) {
        String s = "a";
        String result = reverseStr(s, 2);
        System.out.println(result);
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] sArr = s.toCharArray();
        int l = 0;
        int r;
        for (int i = 0; i < sArr.length; i = i + 2 * k) {
            r = i + k - 1 > sArr.length - 1 ? sArr.length - 1 : i + k - 1;
            reverseArr(sArr, i, r);
        }
        return String.valueOf(sArr);
    }


    private static void reverseArr(char[] chars, int l, int r) {
        char tmp;
        while (l < r) {
            tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
