package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:给定一个二叉树，返回它的中序 遍历。 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-18
 */
public class LeetCode94 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }

    public static void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }


    public static List<Integer> inorderTraversal_01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
