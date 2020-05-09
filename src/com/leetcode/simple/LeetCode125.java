package com.leetcode.simple;

/**
 * @Description:验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/9
 */
public class LeetCode125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome_01(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }
            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
                r--;
            }
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome_01(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
