package 节点间通路;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
// 该算法在1E5 1E5下 TLE
public class FindWhetherExistsPath {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 先初始化成矩阵然后通过target来回退
        // 初始化
        boolean[][] matrix = new boolean[n][n];
        // 初始化联通回路,自环为联通
        for (int i = 0; i < n; i++) {
            matrix[i][i] = true;
        }
        for (int i = 0; i < graph.length; i++) {
            matrix[graph[i][0]][graph[i][1]] = true;
        }
        // 根据下标寻找是否联通，定义保存当前节点
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(target);
        // 保存查找过的节点
//        Vector<Integer> saved = new Vector<Integer>();
        ArrayList<Integer> saved = new ArrayList<>();
        // 开始进行寻找
        while (!stack.isEmpty()) {
            // 拿到当前的pop值
            int temp = stack.pop();
            // 表示已经搜寻过这个点
            saved.add(temp);
            for (int i = 0; i < n; i++) {
                // 所有与之联通的点（需要排除掉自身和之前查找过的点的集合）
                if (matrix[i][temp] == true) {
                    // 确实找到了这个点,直接返回，否则需要进行判断
                    if (i == start) {
                        return true;
                    }
                    // 寻找过或者对角线
                    if (saved.indexOf(i) != -1) {
                        System.out.println("to be continue");
                        System.out.println(i);
                        continue;
                    }
                    // 其余全部入栈
                    stack.push(i);
                    System.out.println(i);
                }

            }
        }
        return false;
    }
}
