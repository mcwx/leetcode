package com.leetcode.simple;

import java.util.Stack;

/**
 * @Description:使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: houpeng
 * @Date: 2019-08-29
 */
public class LeetCode232 {


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.push(3);
        System.out.println(myQueue.peek());

//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.isEmpty());
    }

    static class MyQueue {

        Stack<Integer> stackInput;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackInput = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            while (!stackOut.isEmpty()){
                stackInput.push(stackOut.pop());
            }
            stackInput.push(x);
        }

        public int pop() {
            trans();
            return stackOut.pop();
        }

        public int peek() {
            if(!stackOut.isEmpty()){
                return stackOut.peek();
            }
            trans();
            return stackOut.peek();
        }

        public boolean isEmpty() {
            trans();
            return stackOut.isEmpty();
        }

        void trans(){
            while(!stackInput.isEmpty()){
                stackOut.push(stackInput.pop());
            }
        }

    }
}
