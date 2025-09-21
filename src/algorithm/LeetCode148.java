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


    //复习-2025-09-17
    public ListNode sortList_Review(ListNode head) {
        return mergeSort_Review(head, null);
    }

    //包前不包后
    public ListNode mergeSort_Review(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        if (start.next == end) {
            return new ListNode(start.val);
        }

        //寻找中间节点
        ListNode mid = getMid_Review(start, end);
        ListNode head1 = mergeSort_Review(start, mid);
        ListNode head2 = mergeSort_Review(mid, end);

        //合并
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = new ListNode(head2.val);
                head2 = head2.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(head1.val);
                head1 = head1.next;
                cur = cur.next;
            }
        }

        if(head1!=null){
            cur.next = head1;
        }
        if(head2!=null){
            cur.next = head2;
        }

        return dummy.next;
    }

    public ListNode getMid_Review(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end) {
            fast = fast.next;
            if (fast != end) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}
