package com.leetcode.medium;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:二叉树的前序遍历 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/14
 */
public class LeetCode144 {

    public static void main(String[] args) {
        LinkedList s = new LinkedList();
        TreeNode root = TreeNodeCreator.createTreeNode();
        List<Integer> res = preorderTraversal_01(root);
        System.out.println(res.toString());
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private static void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.getVal());
        preorder(list, root.getLeft());
        preorder(list, root.getRight());
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal_01(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            res.add(treeNode.getVal());
            if (treeNode.getRight() != null) {
                stack.add(treeNode.getRight());
            }
            if (treeNode.getLeft() != null) {
                stack.add(treeNode.getLeft());
            }

        }
        return res;
    }
}
