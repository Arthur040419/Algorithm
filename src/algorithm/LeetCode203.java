package algorithm;

import dataStructure.ListNode;

//移出链表元素
public class LeetCode203 {
    public static void main(String[] args) {

    }

    public static ListNode removeElements_My(ListNode head, int val) {
        //如果链表为空直接返回null
        if(head==null){
            return null;
        }
        //创建一个虚拟头节点
        ListNode dummyNode = new ListNode();
        //虚拟头节点指向真正的头节点，这样删除头节点的操作就和删除其他节点的操作一样
        dummyNode.next = head;
        //创建上一个节点，便于删除节点
        ListNode lastNode = dummyNode;
        //创建当前节点，用于遍历链表
        ListNode node = head;
        //遍历链表
        while (node.next != null) {
            if (node.val == val) {
                //如果值相同就删除该元素
                lastNode.next=node.next;
                //让当前节点指向下一个节点
                node=node.next;
            }else{
                //如果值不同就向前移动一个节点
                lastNode=node;
                node=node.next;
            }
        }
        //单独处理最后一个节点
        if(node.val==val){
            lastNode.next=null;
        }
        //返回正真的头节点
        return dummyNode.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        //参考的别人的代码
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        //创建一个当前节点
        ListNode currentNode = dummyNode;
        while(currentNode.next!=null){
            if(currentNode.next.val==val){
                currentNode.next=currentNode.next.next;
            }else {
                currentNode=currentNode.next;
            }
        }
        return dummyNode.next;
    }

    //复习
    public static ListNode removeElements_Review(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while(curNode.next!=null){
            if(curNode.next.val==val){
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

}
