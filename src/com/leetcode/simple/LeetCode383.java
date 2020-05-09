package com.leetcode.simple;

import java.util.*;

/**
 * @Description:赎金信 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/9
 */
public class LeetCode383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char curChar = magazine.charAt(i);
            if (magazineMap.containsKey(curChar)) {
                magazineMap.put(curChar, magazineMap.get(curChar) + 1);
            } else {
                magazineMap.put(curChar, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char curChar = ransomNote.charAt(i);
            if (magazineMap.get(curChar) == null || magazineMap.get(curChar) <= 0) {
                return false;
            } else {
                magazineMap.put(curChar, magazineMap.get(curChar) - 1);
            }
        }
        return true;
    }
}
