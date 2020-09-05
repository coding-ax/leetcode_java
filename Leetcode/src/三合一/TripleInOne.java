package 三合一;

public class TripleInOne {
    // 使用一个数组和三个指针，分别指向其整数倍
    int[] arr = new int[3];
    int[] data;

    public TripleInOne(int stackSize) {
        // 动态分配三倍+1的空间
        data = new int[3 * (stackSize + 1)];
        // 分配初始值
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
    }

    public void push(int stackNum, int value) {
        // 栈满不压入
        if (isMaxed(stackNum)) {
            return;
        }
        // 后移
        arr[stackNum] += 3;
        // 栈顶赋值
        data[arr[stackNum]] = value;
    }

    public int pop(int stackNum) {
        // 边界判断
        if (isEmpty(stackNum)) {
            return -1;
        }
        // 先拿到结果
        int ans = data[arr[stackNum]];
        // 出栈，指针后移
        arr[stackNum] -= 3;
        return ans;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        // 直接返回结果
        return data[arr[stackNum]];
    }

    // 判断是否为空
    public boolean isEmpty(int stackNum) {
        return arr[stackNum] == stackNum;
    }
    // 判断是否满了
    public  boolean isMaxed(int stackNum){
        return arr[stackNum] == data.length + stackNum - 3;
    }
}
