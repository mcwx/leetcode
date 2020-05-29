package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:二叉树的锯齿形层次遍历 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/29
 */
public class LeetCode103 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
        System.out.println(list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean isLeft2Right = true;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);

        LinkedList<Integer> currLevelList = new LinkedList<>();
        while (!deque.isEmpty()) {
            TreeNode currNode = deque.pollFirst();
            if (currNode != null) {
                if (isLeft2Right) {
                    currLevelList.addLast(currNode.val);
                } else {
                    currLevelList.addFirst(currNode.val);
                }
                if (currNode.left != null) {
                    deque.addLast(currNode.left);
                }
                if (currNode.right != null) {
                    deque.addLast(currNode.right);
                }
            } else {
                result.add(currLevelList);
                currLevelList = new LinkedList<>();
                if (!deque.isEmpty()) {
                    deque.addLast(null);
                    isLeft2Right = !isLeft2Right;
                }
            }
        }
        return result;
    }
}
