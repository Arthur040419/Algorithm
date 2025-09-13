package algorithm;

//83.删除排序链表中的重复元素
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 思路：
         * 用两个指针来遍历，一个指向当前节点cur，另一个指向当前节点的下一个节点curNext
         * 判断当前节点是否与下一个节点值相同，如果相同，就将当前节点的next指向下一个节点的下一个节点
         * 如果不同，就仍然指向下一个节点。
         *
         * 注意：当cur遍历到最后一个元素是，cur.next为空，所以其实不需要遍历到最后一个节点，cur只需要遍历到倒数第二个节点即可。
         */

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;

    }

}
