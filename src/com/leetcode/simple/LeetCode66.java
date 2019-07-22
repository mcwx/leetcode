package com.leetcode.simple;

/**
 * @Description:给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-07-22
 */
public class LeetCode66 {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int flag = 0;
        if (++digits[length - 1] == 10) {
            digits[length - 1] = 0;
            flag = 1;
        }
        int temp;
        for (int i = length - 2; i >= 0; i--) {
            temp = digits[i];
            if (flag == 1) {
                if (++temp == 10) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    flag = 0;
                }
            }
        }
        if (flag == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        } else {
            return digits;
        }
    }
}
