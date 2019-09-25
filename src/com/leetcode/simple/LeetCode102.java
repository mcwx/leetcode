package com.leetcode.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:    二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-25
 */
public class LeetCode102 {

    List<List<Integer>> levelResult = new ArrayList<>();

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * BFS，广度优先算法，queue
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                list.add(poll.val);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 前序遍历，深度优先DFS
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return levelResult;
        }
        helper(root, 0);
        return levelResult;
    }

    public void helper(TreeNode node, int level) {
        if (levelResult.size() == level) {
            levelResult.add(new ArrayList<>());
        }
        levelResult.get(level).add(node.val);
        if (node.left != null) {
            //level++有赋值操作，所以会出错
            //helper(node.left, level++);
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
}
