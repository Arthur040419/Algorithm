package algorithm;

//148.排序链表
public class LeetCode148 {


    public ListNode mergeSort(ListNode head, ListNode tail) {

        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            //这里一定别忘了将尾节点改为null
            head.next = null;
            return head;
        }

        ListNode mid = findMidNode(head, tail);
        //注意这里的划分是包前不包后的
        ListNode left = mergeSort(head, mid);
        ListNode right = mergeSort(mid, tail);
        //合并
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        if (left != null) {
            dummy.next = left;
        }
        if (right != null) {
            dummy.next = right;
        }
        return tmp.next;
    }

    public ListNode findMidNode(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
            slow = slow.next;

        }
        return slow;
    }


    public ListNode sortList(ListNode head) {
        /**
         * 思路：归并排序
         * 归并排序的链表版本
         * 分：
         * 通过快慢指针找到中间节点，慢指针每次走一步，快指针每次走两步，当快指针走到末尾时，慢指针指向的就是中间节点。
         *
         */

        return mergeSort(head, null);

    }

}
