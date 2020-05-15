package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:二叉树的层序遍历 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/14
 */
public class LeetCode102 {

    class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    continue;
                }
                curLevel.add(curNode.val);
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            if (!curLevel.isEmpty()) {
                result.add(curLevel);
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrder_01(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            dfs(result, root, 0);
        }
        return result;
    }

    private static void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (result.size() - 1 < level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        if (node.left != null) {
            dfs(result, node.left, level + 1);
        }
        if (node.right != null) {
            dfs(result, node.right, level + 1);
        }
    }

}
