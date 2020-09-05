package 栈排序;

import java.util.Stack;

public class SortedStack {
    Stack<Integer> stack;

    public SortedStack() {
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        if (isEmpty()) {
            // 为空可以直接插入
            stack.push(val);
        } else {
            // 不为空则需要进行判断了,同样是类似倒豆子，但是这里需要添加判断条件
            // 创建一个临时栈
            Stack<Integer> tempStack = new Stack<Integer>();
            while (true) {
                // 找到了中间值或者到了沉到了底部
                int last = tempStack.empty() ? Integer.MIN_VALUE : tempStack.peek();
                if (stack.isEmpty() || (val >= last && val < stack.peek())) {
                    // 把这个豆子放进去，并且重新把拉出来的豆子装回去
                    stack.push(val);
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                    break;
                }
                // 不满足上述条件就继续找,把豆子放进另一个容器
                tempStack.push(stack.pop());
            }
        }
    }

    public void pop() {
        if (!isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return stack.peek();
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
