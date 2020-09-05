package 链表求和;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = null;
//        ListNode p = null;
//        // 进位设置
//        boolean count = false;
//        while (l1 != null || l2 != null) {
//            // 因为处理位数不等的部分,进行差位运算
//            int l1_val = l1 != null ? l1.val : 0;
//            int l2_val = l2 != null ? l2.val : 0;
//            // 判断和
//            int current = count ? l1_val + l2_val + 1 : l1_val + l2_val;
//            // 处理count
//            count = current >= 10 ? true : false;
//            // 创建新节点
//            ListNode temp = new ListNode(current % 10);
//            // 尾插法
//            if (head == null) {
//                head = temp;
//                p = head;
//            } else {
//                p.next = temp;
//                p = p.next;
//            }
//            // 挪位
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//        // 类似[5] [5]，就还需要一个尾处理
//        if (count == true) {
//            p.next = new ListNode(1);
//        }
//        return head;
//    }
}