package 特定深度节点链表;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        // 为根节点创建一个链表头节点,并且初始化两个队列
        ArrayList<ListNode> res = new ArrayList<ListNode>();
        res.add(new ListNode(tree.val));
        // 初始化队列
        Queue<TreeNode> que1 = new LinkedList<TreeNode>();
        Queue<TreeNode> que2 = new LinkedList<TreeNode>();
        // 头节点加入队列
        que1.add(tree);
        // 先使用数组记录当前层次的数据,最后统一转成链表
        ArrayList<Integer> temp_list = new ArrayList<>();
        while (true) {
            // que1空了
            if (que1.isEmpty()) {
                // que2也是空的了，说明bfs完成了,退出循环
                if (que2.isEmpty()) {
                    break;
                }
                // que2还有值,说明还有层次,则轮换que1和que2,并且存储当前数据为一个链表
                else {
                    ListNode head = null;
                    ListNode p = null;
                    for (int i = 0; i < temp_list.size(); i++) {
                        // 尾插法
                        ListNode temp = new ListNode(temp_list.get(i));
                        if (head == null) {
                            p = temp;
                            head = p;
                            p = head.next;
                        } else {
                            p = temp;
                            p = p.next;
                        }
                    }
                    res.add(head);
                    que1.addAll(que2);
                    que2.clear();
                    continue;
                }
            }
            // 获取当前节点
            TreeNode current = que1.remove();
            if (current.left != null) {
                // 不为空，则将其插入队列2，并且将其加入链表
                temp_list.add(current.left.val);
                que2.add(current.left);
            }
            if (current.right != null) {
                temp_list.add(current.right.val);
                que2.add(current.right);
            }
        }
        String s = "ddd";
      

        ListNode[] ans = new ListNode[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }
        return ans;

    }
}