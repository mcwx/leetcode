package com.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-10
 */
public class LeetCode242 {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            isAnagram("anagram", "nagaram");
        }
        System.out.println(System.currentTimeMillis() - t1);
    }

    /**
     * 第一直觉，map计算法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int value = map.get(c);
                value++;
                map.put(c, value);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) == null) {
                return false;
            } else if (map.get(c) == 1) {
                map.remove(c);
            } else if (map.get(c) > 1) {
                map.put(c, map.get(c) - 1);
            }
        }
        if (map == null || map.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 排序法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 26位计数器
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int c : counter) {
            if (c != 0)
                return false;
        }
        return true;
    }

    /**
     * 哈希表法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (counterMap.containsKey(s.charAt(i))) {
                counterMap.put(s.charAt(i), counterMap.get(s.charAt(i)) + 1);
            } else {
                counterMap.put(s.charAt(i), 1);
            }
            if (counterMap.containsKey(t.charAt(i))) {
                counterMap.put(t.charAt(i), counterMap.get(t.charAt(i)) - 1);
            } else {
                counterMap.put(t.charAt(i), -1);
            }
        }
        for (int value : counterMap.values()) {
            if (value != 0) {
                return false;
            }

        }
        return true;
    }

}
