package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:翻转字符串里的单词 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/11
 */
public class LeetCode151 {

    public static void main(String[] args) {
        String s = "a good   example";
//        System.out.println("s" + s.trim());
        System.out.println(reverseWords_02(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        int p = s.length();
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = s.length() - 2; i >= 0; i--) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (curr == ' ' && next != ' ') {
                sb.append(s, i + 1, p).append(' ');
            } else if (curr != ' ' && next == ' ') {
                p = i + 1;
            }
        }
        return sb.append(s, 0, p).toString();
    }

    public static String reverseWords_01(String s) {
        s = s.trim();
        List<String> sList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(sList);
        return String.join(" ", sList);
    }

    public static String reverseWords_02(String s) {
        int left = 0;
        int right = s.length() - 1;
        //去除首位空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        //去除中间多余的空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
                left++;
            } else {
                sb.append(' ');
                while (s.charAt(left) == ' ') {
                    left++;
                }
            }
        }
        char[] charArr = sb.toString().toCharArray();
        reverseCharArr(charArr, 0, charArr.length - 1);
        int i = 0;
        for (int j = 0; j < charArr.length; j++) {
            if (charArr[j] == ' ') {
                reverseCharArr(charArr, i, j - 1);
                i = j + 1;
            }
        }
        reverseCharArr(charArr, i, charArr.length - 1);
        return new String(charArr);
    }

    private static void reverseCharArr(char[] charArr, int left, int right) {
        char tmp;
        while (left < right) {
            tmp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = tmp;
            left++;
            right--;
        }
    }
}
