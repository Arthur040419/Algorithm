package algorithm;

import dataStructure.ListNode;


//234.回文链表
public class LeetCode234 {
    //递归思路的外置指针
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


    //递归思路
    public boolean isPalindrome2(ListNode head) {
        //初始化外置指针
        fontNode = head;
        return checkCurNode(head);
    }

    //通过递归遍历节点，让节点达到链表最后一个位置，然后往回逐个与外置指针比较，从而判断是否是回文链表
    public boolean checkCurNode(ListNode head){
        if(head!=null){
            //先递归检查下一个节点
            if(!checkCurNode(head.next)){
                return false;
            }
            //再检查当前节点
            if(head.val!= fontNode.val){
                return false;
            }
            fontNode = fontNode.next;
        }
        //到达最末尾的第一个空节点，直接返回true
        return true;
    }

}
