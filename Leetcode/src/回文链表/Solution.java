package 回文链表;

import java.lang.reflect.Type;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public static void main(String[] args) {
        Stack sta = new Stack();
        sta.push(1);
        sta.push(2);
        int co = (int)sta.pop();
        System.out.println(co);
    }
}