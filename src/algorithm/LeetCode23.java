package algorithm;

//23.合并K个升序链表
public class LeetCode23 {

    public static void main(String[] args) {

    }

    //方法1，循环k次，每次合并一个链表
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeList(res, lists[i]);
        }
        return res;
    }

    public static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummyHead.next;
    }

}
