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
        while (list1!=null&&list2!=null){
            if(list1.val> list2.val){
                result.next = list2;
                list2 = list2.next;
            }else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }

        if(list1!=null){
            result.next = list1;
        }else {
            result.next = list2;
        }

        return finalResult.next;

    }
}
