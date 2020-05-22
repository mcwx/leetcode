package com.leetcode.simple;

/**
 * @Description:猜数字大小 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/22
 */
public class LeetCode374 {
    final private int pick = 6;

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int mid = -1;
        while (l <= n) {
            mid = l + (r - l) / 2;
            if (guess(mid) == 1) {
                l = mid + 1;
            } else if (guess(mid) == -1) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    private int guess(int num) {
        if (num == pick) {
            return 0;
        } else if (num < pick) {
            return 1;
        } else {
            return -1;
        }
    }
}
