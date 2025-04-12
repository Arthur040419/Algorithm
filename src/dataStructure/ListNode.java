package dataStructure;

public class ListNode {
    //节点的值
    public int val;

    //下一个节点的地址
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    //这个好像不大需要
//    public ListNode(ListNode next) {
//        this.next = next;
//    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
