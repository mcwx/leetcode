package com.leetcode.medium;

/**
 * @Description:字符串的排列 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/7
 */
public class LeetCode567 {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion_02(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (matches(s1map, s2map)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion_01(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)) return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    /**
     * 滑动窗口（优化）
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion_02(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i]) count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) {
                return true;
            }
            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + s1.length()) - 'a';

            s2map[r]++;
            if (s1map[r] == s2map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }

            s2map[l]--;
            if (s1map[l] == s2map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }

        }
        return count == 26;
    }

    private static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }
}
