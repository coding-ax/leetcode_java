package 动物收容所;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf {
    Queue<int[]> cat_queue;
    Queue<int[]> dog_queue;
    int count;

    public AnimalShelf() {
        // 猫狗分开并指定静态的count作为时间
        cat_queue = new LinkedList<int[]>();
        dog_queue = new LinkedList<int[]>();
        count = 0;
    }

    public void enqueue(int[] animal) {
        count++;
        int[] temp = new int[2];
        // 编号
        temp[0] = animal[0];
        // 加入时间
        temp[1] = count;
        // 分猫狗
        if (animal[1] == 0) {
            cat_queue.add(temp);
        } else if (animal[1] == 1) {
            dog_queue.add(temp);
        }
    }

    public int[] dequeueAny() {
        int[] ans = new int[2];
        if (!cat_queue.isEmpty() && !dog_queue.isEmpty()) {
            int[] cat_latest = cat_queue.peek();
            int[] dog_latest = dog_queue.peek();
            if (cat_latest[1] < dog_latest[1]) {
                // 如果猫的时间长
                cat_queue.remove();
                ans[0] = cat_latest[0];
                ans[1] = 0;
            } else {
                dog_queue.remove();
                ans[0] = dog_latest[0];
                ans[1] = 1;
            }
        } else if (cat_queue.isEmpty() && !dog_queue.isEmpty()) {
            int[] dog_latest = dog_queue.peek();
            dog_queue.remove();
            ans[0] = dog_latest[0];
            ans[1] = 1;
        } else if (!cat_queue.isEmpty() && dog_queue.isEmpty()) {
            int[] cat_latest = cat_queue.peek();
            cat_queue.remove();
            ans[0] = cat_latest[0];
            ans[1] = 0;
        } else if (cat_queue.isEmpty() && dog_queue.isEmpty()) {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public int[] dequeueDog() {
        int[] ans = new int[2];
        if (!dog_queue.isEmpty()) {
            int[] dog = dog_queue.remove();
            ans[0] = dog[0];
            ans[1] = 1;

        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public int[] dequeueCat() {
        int[] ans = new int[2];
        if (!cat_queue.isEmpty()) {
            int[] cat = cat_queue.remove();
            ans[0] = cat[0];
            ans[1] = 0;

        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}
