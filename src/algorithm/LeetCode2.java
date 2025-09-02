package algorithm;

//2.两数相加
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思路：
         * 直接模拟，按位相加，模拟的代码参考的LeetCode官方题解
         */


        ListNode head = null;
        ListNode tail = null;

        //进位
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }

            int sum = num1 + num2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum/10;

        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }

        return head;
    }

}
