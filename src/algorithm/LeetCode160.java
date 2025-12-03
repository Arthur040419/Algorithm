package algorithm;

import dataStructure.ListNode;

//链表相交
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*思路：
         * 首先统计A、B两条链表的长度，假设分别为n、m
         * 使用curA、curB两个指针分别指向A、B链表
         * 将两条链表尾部对齐，这里假设m>n，那么对齐方式就是curB先向前移动m-n个节点
         * 尾部对齐后，curA和curB同时向前移动，移动的同时判断curA和curB地址是否相同，如果地址相同，那么该节点就是链表相交的起始节点
         * */

        //curA指针指向链表A
        ListNode curA = headA;
        //curB指针指向链表B
        ListNode curB = headB;
        //计算链表A的长度
        int lenA = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        curA = headA;

        //计算链表B的长度
        int lenB = 0;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curB = headB;

        //尾部对齐
        //如果链表A长
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        }
        //如果链表B长
        if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }

        //尾部对齐后开始寻找链表相交的起始节点
        while (curA != null) {
            if (curA == curB) {
                return curA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }

    //新思路
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         * 这个思路其实就是上面采用的思路的一种变形:
         * headA和headB同时开始遍历，如果headA到达链表末尾就重新让其指向headB，如果headB到达链表末尾，就重新让其指向headA
         * 就这样一直遍历，知道两个指针指向同一个节点或者都指向null。
         * 这种思路可以抽象成将两个链表连接到一块，如果两个链表存在相交的情况，那么最终两个指针一定会指向同一个节点
         */

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }


    //复习-2025-09-17
    public ListNode getIntersectionNode_Review2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }


    //复习
    public ListNode getIntersectionNode_Review1(ListNode headA, ListNode headB) {
        //计算两个链表的长度
        int len1 = 0;
        int len2 = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            len1++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            len2++;
            tmp = tmp.next;
        }

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }


    //复习-2025-10-24
    public ListNode getIntersectionNode_Review3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode indexA = headA;
        ListNode indexB = headB;
        while (indexA != indexB) {
            indexA = indexA == null ? headB : indexA.next;
            indexB = indexB == null ? headA : indexB.next;

        }
        return indexA;
    }


}
