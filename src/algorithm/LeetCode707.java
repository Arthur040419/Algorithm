package algorithm;

//设计链表
public class LeetCode707 {

}


/**
 * 在模拟链表这种数据结构的时候最好能有一个统一的规定，例如要先弄清楚size代表什么，是当前链表最大索引还是当前链表长度，再如链表要不要虚拟头节点。
 * 有一个统一的规定模拟起来才不会混乱，再下次遇到的时候心里也有一个整体的规范，不然脑袋里面就会变来变去，非常影响编写代码
 * 这里我就做一个统一的规范，以后遇到链表相关的模拟就按这个规范来
 * 1.采用单链表，一个节点只包含val和next
 * 2.采用虚拟头节点
 * 3.size代表链表的实际长度
 */
class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //链表的虚拟头节点
    ListNode head;
    //链表的实际长度
    int size;

    public MyLinkedList() {
        //初始化链表
        head = new ListNode();
        size = 0;
    }

    public int get(int index) {
        //获取指定索引的节点
        //首先处理非法索引
        if(index<0||index>=size){
            return -1;
        }
        //当前节点
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur=cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        //在头节点前面添加元素
        //让新节点的next指向原来的头节点
        ListNode newNode = new ListNode(val,head.next);
        //只需让虚拟头节点指向要添加的节点即可
        head.next = newNode;
        //别忘了让链表的长度+1
        size++;
    }

    public void addAtTail(int val) {
        //在尾节点后面添加元素
        ListNode cur = head;
        //先遍历节点，一直到尾节点
        while(cur.next!=null){
            cur=cur.next;
        }
        //创建一个新节点并让旧尾节点指向新尾节点
        ListNode newNode = new ListNode(val,null);
        cur.next=newNode;
        //别忘了让链表长度+1
        size++;
    }

    public void addAtIndex(int index, int val) {
        //在指定索引位置添加元素
        //首先处理非法索引，在这里索引为size的情况并不是非法情况，如果索引为size，说明新节点是插入到链表尾部的
        if(index<0||index>size){
            return;
        }
        //遍历链表，直到目标索引的前驱节点
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        //新建要插入的节点，并让新节点指向原来在这个索引位置的节点
        ListNode newNode = new ListNode(val,cur.next);
        //让前驱节点指向新节点
        cur.next=newNode;
        //别忘了让链表长度+1
        size++;
    }

    public void deleteAtIndex(int index) {
        //删除指定索引的节点
        //处理非法索引
        if(index<0||index>=size){
            return;
        }
        ListNode cur = head;
        //遍历到要删除节点的前驱节点
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        //直接让前驱节点指向被删除节点的下一个节点即可
        cur.next=cur.next.next;
        //别忘了让链表长度-1
        size--;
    }
}
