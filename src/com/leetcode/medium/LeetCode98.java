package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:验证二叉搜索树 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-09-17
 */
public class LeetCode98 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST1(root));
    }


    /**
     * 中序遍历法
     *
     * @param root
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min >= list.get(i)) {
                return false;
            }
            min = list.get(i);
        }
        return true;
    }

    /**
     * 中序遍历（递归）
     *
     * @param node
     * @param list
     */
    public static void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.val);
            inOrderTraversal(node.right, list);
        }
    }

    /**
     * 中序遍历（迭代）
     *
     * @param root
     */
    public static boolean isValidBST1(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 循环添加左节点
            }
            cur = toVisit.pop(); // 当前栈顶已经是最底层的左节点了，取出栈顶元素，访问该节点
            list.add(cur.val);
            cur = cur.right; // 添加右节点
        }
        int min = Integer.MIN_VALUE;
        for (int val : list) {
            if (val <= min) {
                return false;
            } else {
                min = val;
            }
        }
        return true;
    }
}
