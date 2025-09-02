package algorithm;


import java.util.Scanner;

public class TXMain {
    public static void main(String[] args) {
        ListNode head = new ListNode();

        //慢指针
        int slow = 0;
        //快指针
        int fast = 0;

    }
}


class ListNode{
    int val;
    ListNode next;


    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
