package com.leetcode.util;


import java.util.List;

/**
 * @Description:二叉树排序
 * @Auther: houpeng
 * @Date: 2019-09-24
 */
public class BinaryTreeTraversal {

    /**
     * 前序排列
     * @param node
     * @param list
     */
    public void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    /**
     * 中序排列
     * @param node
     * @param list
     */
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    /**
     * 后序排列
     * @param node
     * @param list
     */
    public void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
