package com.leetcode.difficulty;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/14
 */
public class LeetCode145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(result, root);
        return result;
    }


    private static void postorder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(result, root.getLeft());
        postorder(result, root.getRight());
        result.add(root.getVal());
    }

    public static List<Integer> postorderTraversal_01(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            result.addFirst(treeNode.getVal());

            if (treeNode.getLeft() != null) {
                stack.add(treeNode.getLeft());
            }
            if (treeNode.getRight() != null) {
                stack.add(treeNode.getRight());
            }
        }
        return result;
    }
}
