package com.leetcode.simple;

/**
 * @Description:反转一个单链表。 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Auther: houpeng
 * @Date: 2019-08-22
 */
public class LeetCode206 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode head = this;
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val + " ");
                head = head.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        System.out.println(reverseList_01(ln));
    }

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList_01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList_01(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
