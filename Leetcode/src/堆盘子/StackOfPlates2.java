package 堆盘子;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates2 {
    ArrayList<Stack<Integer>> data;
    int size;
    int current_i;

    public StackOfPlates2(int cap) {
        size = cap;
        current_i = -1;
        data = new ArrayList<Stack<Integer>>();
    }

    public void push(int val) {
        // 如果此时在j顶端，或者为空,那么必须得使用新的位置
        if (size == 0) return;
        if (isEmpty() || data.get(current_i).size() == size) {
            current_i++;
            data.add(new Stack<Integer>());
        }
        data.get(current_i).push(val);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            // 拿到最后一个值
            int temp = (int) data.get(current_i).peek();
            // 去除最后一个的
            data.get(current_i).pop();
            // 如果这骡空了，那就移除它并把i指针回退
            if (data.get(current_i).isEmpty()) {
                data.remove(current_i);
                current_i--;
            }
            return temp;
        }
    }

    public int popAt(int index) {
        // 边界处理
        if (index > current_i) {
            System.out.println(index);
            return -1;
        } else {
            // 带index的pop
            // 拿到当前长度和值
            int temp = (int) data.get(index).peek();
            data.get(index).pop();
            // 移除它并令长度减一
            // 如果长度减到-1，那么直接移除,同时current_i降低
            if (data.get(index).isEmpty()) {
                data.remove(index);
                current_i--;
            }
            return temp;
        }
    }

    public boolean isEmpty() {
        return current_i == -1;
    }
}
