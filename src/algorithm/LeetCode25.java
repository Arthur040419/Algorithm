package algorithm;

//25.K个一组翻转链表
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            ListNode[] reverse = reverse(prev.next, tail);
            prev.next = reverse[0];
            prev = reverse[1];
            head = tail.next;
        }
        return dummyHead.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return new ListNode[]{tail, head};
    }

}
