package com.leetcode.simple;

/**
 * @Description: 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-06-28
 */
public class LeetCode28 {

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 使用封装好的方法实现功能（是否是偷懒呢？）
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf("");
    }

    public static int strStr_01(String haystack, String needle) {
//        if (haystack == null) {
//            return -1;
//        }
        if (needle == "") {
            return 0;
        }
        char[] charsHaystack = haystack.toCharArray();
        char[] charsNeedle = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < charsHaystack.length - charsNeedle.length + 1; i++) {
            int k = i;
            while (j < charsNeedle.length && charsHaystack[k] == charsNeedle[j]) {
                k++;
                j++;
            }
            if (j == charsNeedle.length) {
                return i;
            } else {
                j = 0;
            }
        }
        return -1;
    }
}
