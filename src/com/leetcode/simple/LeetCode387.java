package com.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:字符串中的第一个唯一字符 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/9
 */
public class LeetCode387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            alphabet[sArr[i] - 'a']++;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (alphabet[sArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
