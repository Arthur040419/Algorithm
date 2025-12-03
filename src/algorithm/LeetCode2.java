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
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            int sum = num1 + num2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;

        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    //复习-2025-09-17
    public ListNode addTwoNumbers_Review(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;

            if (head == null) {
                head = new ListNode(sum);
                tail = head;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //复习-2025-10-24
    public ListNode addTwoNumbers_Review2(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummyHead = new ListNode();
        ListNode res = dummyHead;
        int carry = 0;
        int tmp = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            tmp = n1 + n2 + carry;
            carry = tmp / 10;
            tmp %= 10;
            res.next = new ListNode(tmp);
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
