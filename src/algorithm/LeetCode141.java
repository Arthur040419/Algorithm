package algorithm;

//141.环形链表
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        /**
         * 思路：快慢指针
         * 两个指针同时从头节点出发，慢指针一次走一步，快指针一次走两步，如果快指针最后能够和慢指针重叠，就说明链表有环
         */

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && slow != null) {
            if(fast.next!=null){
                fast = fast.next.next;
            }else {
                return false;
            }
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}
