package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2020/5/26
 */
public class LeetCode445 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = new ListNode(0);
        int carry = 0;
        int currSum;
        ListNode currNode = result;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            currSum = num1 + num2 + carry;
            currNode.next = new ListNode(currSum % 10);
            carry = currSum / 10;
            currNode = currNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        currNode.next = carry == 1 ? new ListNode(1) : null;
        result = result.next;
        return reverse(result);
    }

    /**
     * 头插法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_01(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = null;
        int carry = 0;
        int currSum;
        ListNode currNode;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            currSum = num1 + num2 + carry;
            currNode = new ListNode(currSum % 10);
            currNode.next = result;
            result = currNode;
            carry = currSum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            currNode = new ListNode(1);
            currNode.next = result;
            result = currNode;
        }
        return result;
    }

    /**
     * 逆序法需要立刻想到栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_02(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode result = null;
        ListNode currNode;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int currSum = num1 + num2 + carry;
            currNode = new ListNode(currSum % 10);
            currNode.next = result;
            result = currNode;
            carry = currSum / 10;
        }
        if (carry == 1) {
            currNode = new ListNode(1);
            currNode.next = result;
            result = currNode;
        }
        return result;
    }


    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode reverse_01(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
