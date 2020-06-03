package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:矩阵置零 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/6/3
 */
public class LeetCode73 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZero_01(matrix);
    }

    public void setZero(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZero_01(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    int r = 0;
                    int c = 0;
                    while (r < matrix.length) {
                        if (matrix[r][j] == 0) {
                            r++;
                            continue;
                        }
                        matrix[r++][j] = Integer.MIN_VALUE;
                    }
                    while (c < matrix[i].length) {
                        if (matrix[i][c] == 0) {
                            c++;
                            continue;
                        }
                        matrix[i][c++] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZero_02(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                int j = 0;
                while (j < matrix[i].length) {
                    matrix[i][j++] = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                int j = 0;
                while (j < matrix.length) {
                    matrix[j++][i] = 0;
                }
            }
        }
    }
}
