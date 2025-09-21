package algorithm;

import dataStructure.ListNode;

//删除链表的倒数第N个节点
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*思路：
         *快慢指针
         * 定义一个快指针fast和一个慢指针slow
         * 让fast先移动n个节点
         * 然后slow和fast同时移动，直到fast到达末尾，注意不是最后一个节点，而是链表的末尾，即：最后fast指针为null
         * 此时slow指向的节点就是要删除的节点
         * */

        //定义一个虚拟头节点
        ListNode dummy = new ListNode(0, head);
        //快指针,指向虚拟节点
        ListNode fast = dummy;
        //慢指针,指向虚拟节点
        ListNode slow = dummy;
        //快指针先移动n+1个节点，正常来说移动n个节点就可以了，这里移动n+1个节点是为了让slow指针指向要删除的节点的前驱节点，方便进行删除操作
        for (int i = 0; i < n + 1; i++) {
            //注意处理异常情况，如果fast在这个过程中变为了null，说明倒数第n个节点根本不存在，直接返回原来的链表
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        //接着让快慢指针同时移动，直到fast指向结尾的null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //循环结束，找到要删除节点的前驱节点，进行删除操作
        slow.next = slow.next.next;
        //返回虚拟头节点指向的节点，即新的头节点
        return dummy.next;
    }

    //复习-2025-09-17
    public ListNode removeNthFromEnd_Review(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //删除倒数第n个节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
