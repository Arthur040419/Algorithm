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
}