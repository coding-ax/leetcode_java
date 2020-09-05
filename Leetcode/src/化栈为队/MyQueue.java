package 化栈为队;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1, stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack2.isEmpty()) {
            // 倒豆子
            stack1.push(stack2.pop());
        }
        // 把x倒入进去
        stack1.push(x);
        // 再倒回来
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();
    }
}
