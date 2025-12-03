package algorithm;

import dataStructure.ListNode;

//环形链表
public class LeetCode142 {
    //快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //创建一个虚拟头节点
        ListNode dummy = new ListNode(0, head);
        //首先找到快慢指针相遇的点
        //初始化快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果fast.next为null，则说明没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        //如果fast不为null，说明存在环，且当前节点就是快慢指针相遇的节点
        //此时重新创建一个新指针从头节点出发，fast也同时从相遇节点出发，当这两个节点相遇时就说明相遇处为环的入口节点
        ListNode newNode = dummy;
        while (newNode != fast) {
            newNode = newNode.next;
            fast = fast.next;
        }
        return fast;
    }

    //复习-2025-09-17
    public ListNode detectCycle_Review(ListNode head) {
        //先判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || slow == null) {
            return null;
        }

        //找到环的入口
        ListNode node1 = fast;
        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


    //复习-2025-10-24
    public ListNode detectCycle_Review2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if(fast==null||slow==null){
            return null;
        }

        //确定环入口
        ListNode start = head;
        while (fast != start) {
            fast = fast.next;
            start = start.next;
        }
        return start;
    }
}
