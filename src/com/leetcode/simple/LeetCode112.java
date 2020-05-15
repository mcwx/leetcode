package com.leetcode.simple;

import java.util.LinkedList;

/**
 * @Description:路径总和 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/15
 */
public class LeetCode112 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
    }

    public static boolean hasPathSum_01(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.push(root);
        sumStack.push(sum - root.val);
        TreeNode node;
        int currSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            currSum = sumStack.pop();
            if (node.left == null && node.right == null && currSum == 0) {
                return true;
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }
        }
        return false;
    }
}
