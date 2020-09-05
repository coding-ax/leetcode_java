package 栈的最小值;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
    // 结构体
    private class Pair {
        public long value, min;

        public Pair(long val, long m) {
            value = val;
            min = m;
        }
    }

    /**
     * initialize your data structure here.
     */
    Stack<Pair> sta = new Stack();

    // 结构体思路：每次都记录当时插入时的最小值
    public MinStack() {

    }

    public void push(long x) {
        // 当前最小
        if (sta.isEmpty()) {
            sta.push(new Pair(x, x));
        } else sta.push(new Pair(x, Math.min(getMin(), x)));
    }

    public void pop() {
        sta.pop();
    }

    public long top() {
        return sta.peek().value;
    }

    public long getMin() {
        return sta.peek().min;
    }
}
