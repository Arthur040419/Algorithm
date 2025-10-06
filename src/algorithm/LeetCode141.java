package algorithm;

//141.环形链表
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        /**
         * 思路：
         * 这道题只要求判断是否有环，并没有要求给出从哪个节点开始进入环，所以相对比较简单。
         * 采用快慢指针（龟兔赛跑算法）
         * 快指针一次走两步，慢指针一次走一步，一旦这两个指针相遇，就说明链表有环
         */

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            if (fast.next != null) {
                //这里注意要是没有上面的if判断，可能会产生空指针。
                fast = fast.next.next;
            }else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
