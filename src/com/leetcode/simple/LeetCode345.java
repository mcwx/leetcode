package com.leetcode.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:反转字符串中的元音字母 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/9
 */
public class LeetCode345 {

    private static final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        String s = "aA";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] sArr = s.toCharArray();

        int l = 0;
        int r = sArr.length - 1;
        char tmp;
        while (l < r) {
            while (!set.contains(sArr[l]) && l < r) {
                l++;
            }
            while (!set.contains(sArr[r]) && l < r) {
                r--;
            }
            tmp = sArr[l];
            sArr[l] = sArr[r];
            sArr[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(sArr);
    }

}
