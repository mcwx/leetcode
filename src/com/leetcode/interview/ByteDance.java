package com.leetcode.interview;

/**
 * @Description:
 * @Auther: houpeng
 * @Date: 2020/5/24
 */
public class ByteDance {

    public static void main(String[] args) {
        System.out.println(deleteAssignStr("acbac"));
        System.out.println(deleteAssignStr("aaac"));
        System.out.println(deleteAssignStr("ababac"));
        System.out.println(deleteAssignStr("bbbbbd"));
        System.out.println(deleteAssignStr("aaaabbcccc"));
    }

    /**
     * 写一个程序，去掉字符串中的ac和b，例如字符串为aaccbdef，去掉ac、b后为def（不能用正则表达式也不能用replace函数）
     *
     * @param s
     * @return
     */
    public static String deleteAssignStr(String s) {
        char[] charArr = s.toCharArray();
        int i = 0;//需要放置结果的位置
        for (int j = 0; j < charArr.length; j++) {
            if (charArr[j] == 'c') {
                if (i > 0 && charArr[i - 1] == 'a') {
                    i--;
                } else {
                    charArr[i] = charArr[j];
                    i++;
                }
            } else if (charArr[j] != 'b') {
                charArr[i] = charArr[j];
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(charArr[j]);
        }
        return sb.toString();
    }

}
