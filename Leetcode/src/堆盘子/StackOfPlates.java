package 堆盘子;

import java.util.ArrayList;
import java.util.Vector;

public class StackOfPlates {
    ArrayList<ArrayList> data;
    int size;
    int current_i, current_j;

    public StackOfPlates(int cap) {
        size = cap;
        current_i = -1;
        current_j = -1;
    }

    public void push(int val) {
        // 如果此时在j顶端，或者为空,那么必须得使用新的位置
        if (current_j == size - 1 || isEmpty()) {
            current_i++;
            data.add(new ArrayList());
            current_j = 0;
            data.get(current_i).add(val);
        } else {
            // 否则
            current_j++;
            data.get(current_i).add(val);
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            // 拿到最后一个值
            int temp = (int) data.get(current_i).get(current_j);
            // 去除最后一个的
            data.get(current_i).remove(current_j);
            current_j--;
            // 如果这骡空了，那就移除它并把j指针回退
            if (current_j == -1) {
                data.remove(current_i);
                current_i--;
                // 回退，如果i也没了，那么就只有-1，否则回到其倒数第二个的顶部
                current_j = current_i == -1 ? -1 : data.get(current_i).size() - 1;
            }
            return temp;
        }
    }

    public int popAt(int index) {
        // 边界处理
        if (index > current_i) {
            return -1;
        } else {
            // 带index的pop
            // 拿到当前长度和值
            int length = data.get(index).size() - 1;
            int temp = (int) data.get(index).get(length);
            // 移除它并令长度减一
            data.get(index).remove(length);
            length--;
            // 如果长度减到-1，那么直接移除,同时current_i降低
            if (length == -1) {
                data.remove(index);
                current_i--;
            }
            return temp;
        }
    }

    public boolean isEmpty() {
        return current_i == -1 && current_j == -1;
    }
}
