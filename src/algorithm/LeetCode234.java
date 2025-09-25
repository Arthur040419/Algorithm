package algorithm;

import dataStructure.ListNode;


//234.回文链表
public class LeetCode234 {

    //递归做法
    ListNode fontNode;

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        //获取后半部分链表的头节点
        ListNode head2 = reverseList(mid);
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    //获取中间节点
    public ListNode getMid(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //反转后半部分链表，返回后半部分链表的头指针
    public ListNode reverseList(ListNode head) {
        //前驱节点
        ListNode preNode = null;
        //当前节点
        ListNode curNode = head;
        //临时节点
        ListNode tmpNode = null;
        while (curNode != null) {
            tmpNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tmpNode;
        }
        return preNode;
    }

    //复习-2025-09-17  新思路-递归
    public boolean isPalindrome_Review(ListNode head) {
        fontNode = head;
        return isPalindromeCheck(head);
    }

    public boolean isPalindromeCheck(ListNode node) {
        if (node != null) {
            if(!isPalindromeCheck(node.next)){
                return false;
            }
            if(node.val!=fontNode.val){
                return false;
            }

            fontNode = fontNode.next;
        }
        return true;
    }

}
