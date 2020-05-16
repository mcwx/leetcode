package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:对角线遍历 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/16
 */
public class LeetCode498 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        //M行(纵坐标最大值)
        int M = matrix.length;
        //N列(横坐标最大值)
        int N = matrix[0].length;
        int[] result = new int[M * N];
        int k = 0;
        List<Integer> currList = new ArrayList<>();
        for (int i = 0; i < M + N - 1; i++) {
            currList.clear();
            //横坐标
            int c = (i < N) ? i : N - 1;
            //纵坐标
            int r = (i < N) ? 0 : i - N + 1;
            while (c >= 0 && r <= M - 1) {
                currList.add(matrix[r][c]);
                c--;
                r++;
            }
            if (i % 2 == 1) {
                for (int j = 0; j < currList.size(); j++) {
                    result[k++] = currList.get(j);
                }
            } else {
                for (int j = currList.size() - 1; j >= 0; j--) {
                    result[k++] = currList.get(j);
                }
            }
        }
        return result;
    }
}
