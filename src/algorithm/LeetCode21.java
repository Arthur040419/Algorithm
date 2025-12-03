package algorithm;

//21.合并两个有序链表
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /**
         * 思路：
         * 简单题，双指针，分别指向两个链表，哪个指针指向的值更小，哪个就作为新链表的下一个节点
         *
         * 其他思路：递归（挖个坑）
         *
         */

        //虚拟头节点
        ListNode result = new ListNode();
        ListNode finalResult = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }

        if (list1 != null) {
            result.next = list1;
        } else {
            result.next = list2;
        }

        return finalResult.next;

    }

    //复习-2025-09-17
    public ListNode mergeTwoLists_Review(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummyHead = new ListNode();
        ListNode newList = dummyHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newList.next = cur1;
                newList = newList.next;
                cur1 = cur1.next;
            } else {
                newList.next = cur2;
                newList = newList.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            newList.next = cur1;
        }

        if (cur2 != null) {
            newList.next = cur2;
        }

        return dummyHead.next;
    }

    //复习-2025-10-24
    public ListNode mergeTwoLists_Review2(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummyHead = new ListNode();
        ListNode res = dummyHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                res.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            } else {
                res.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            }
            res = res.next;
        }
        if (cur1 != null) {
            res.next = cur1;
        }
        if (cur2 != null) {
            res.next = cur2;
        }

        return dummyHead.next;
    }
}
