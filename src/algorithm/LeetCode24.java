package algorithm;

import dataStructure.ListNode;

//两两交换链表中的节点
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        //处理空链表和长度为1的链表的情况
        if (head == null || head.next == null) {
            return null;
        }
        //记住第二个节点，最后直接返回这个节点
        ListNode newHead = head.next;
        //使用虚拟头节点
        //让cur指向虚拟头节点
        ListNode cur = new ListNode(0, head);
        //如果当前节点不为空并且当前节点后面的节点数不少于两个，就两两交换处理
        while (cur != null && cur.next != null && cur.next.next != null) {
            //创建两个变量来代表进行两两交换的节点，会让思路清晰一点
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            //临时变量记住第三个节点
            ListNode tmp = second.next;
            //让当前节点指向第二个节点
            cur.next = second;
            //让第二个节点指向第一个节点
            second.next = first;
            //让第一个节点指向第二个节点的下一个节点
            //first.next=second.next;   这里注意一下，我第一次写的代码是这样的，但是前面second.next已经被修改了，所以这行代码实际上first.next=first，指向自己了
            //应该用于个临时变量来记住第三个节点
            first.next = tmp;
            //让当前节点的指针向前移动
            cur = first;
        }
        //处理好后直接返回处理前的第二个节点
        return newHead;
    }


    //复习-2025-09-17
    public ListNode swapPairs_Review(ListNode head) {
        /**
         * 创建虚拟头节点，从虚拟头节点开始，每次使用一个临时tmp节点去指向需要交换的两个节点的前一个节点
         */
        ListNode dummy = new ListNode(0, head);
        ListNode tmp = dummy;
        while (tmp != null && tmp.next != null && tmp.next.next != null) {
            ListNode first = tmp.next;
            ListNode second = first.next;
            ListNode third = second.next;
            tmp.next = second;
            second.next = first;
            first.next = third;
            tmp = first;
        }
        return dummy.next;
    }
}

