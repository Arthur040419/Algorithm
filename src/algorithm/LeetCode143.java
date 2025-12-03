package algorithm;

import java.util.ArrayList;
import java.util.List;

//143.重排链表 - 2025-10-30 东方财富一面手撕，没写出来
public class LeetCode143 {

    //方法一，线性表
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            nodes.add(tmp);
            tmp = tmp.next;
        }

        int left = 0;
        int right = nodes.size() - 1;

        while (left < right) {
            ListNode leftNode = nodes.get(left);
            ListNode rightNode = nodes.get(right);
            tmp = leftNode.next;

            leftNode.next = rightNode;
            rightNode.next = tmp;
            left++;
            right--;
        }

        //将最后一个节点的next置为null
        nodes.get(left).next = null;

    }

    //方法二
    public void reorderList2(ListNode head) {
        /**
         * 将链表分为两半，将右半部分翻转，然后合并两个链表就是最终答案
         */

        //寻找链表中点
        ListNode midNode = getMidNode(head);

        //翻转链表
        ListNode head2 = reverseList(midNode.next);

        midNode.next = null;

        //合并链表
        ListNode dummyNode = new ListNode();
        ListNode list1 = head;
        ListNode list2 = head2;
        ListNode tmpList1 = null;
        ListNode tmpList2 = null;

        while (list1 != null && list2 != null) {
            tmpList1 = list1.next;
            tmpList2 = list2.next;

            list1.next = list2;
            list2.next = tmpList1;

            list1 = tmpList1;
            list2 = tmpList2;
        }
    }


    public ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    //翻转链表，返回翻转后的头节点
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
