package algorithm;

import dataStructure.ListNode;

//反转链表
public class LeetCode206 {

}
class Solution {
    public ListNode reverseList(ListNode head) {
        //双指针法
        //当前节点
        ListNode cur = head;
        //前驱节点
        ListNode pre = null;
        //临时节点
        ListNode tmp = null;
        while(cur!=null){
            //保存下一个节点的位置
            tmp=cur.next;
            cur.next=pre;
            //两个指针都向前移动一个节点
            pre=cur;
            cur=tmp;
        }
        return pre;
    }

    //后面回来复习
    public ListNode reverseList_1(ListNode head) {
        /**
         * 思路：
         * 要反转整个链表，只需要将每一个节点的指针反过来就行
         */
        //当前节点
        ListNode curNode = head;
        //前驱节点
        ListNode preNode = null;
        //交换指针时的临时节点
        ListNode tmpNode = null;

        //遍历链表
        while (curNode!=null){
            //让当前节点的下一个节点指向前驱节点
            tmpNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tmpNode;
        }
        return preNode;
    }
}