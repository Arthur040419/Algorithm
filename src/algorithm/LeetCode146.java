package algorithm;

import java.util.HashMap;

//146.LRU缓存
public class LeetCode146 {

}

class LRUCache {

    int capacity;
    //当前缓存使用量
    int size;
    Node dummyHead;
    Node dummyTail;
    HashMap<Integer, Node> hashMap = new HashMap<>();

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node() {

        }

        public Node(int key,int val, Node next, Node pre) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    public LRUCache(int capacity) {
        /**
         * 实现LRU缓存，LRU即为最近最久未被使用缓存淘汰算法。
         * 可以基于一个双向链表来实现，链表最前面的是最近被使用过的，链表最后面的就是最近最久没被使用过的。
         */

        this.capacity = capacity;
        this.size = 0;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node != null) {
            //将节点移动到最前面
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if(node==null){
           node = new Node();
           node.val = value;
           node.key = key;
           addHead(node);
           size++;
        }else {
            node.key = key;
            node.val = value;
            moveToHead(node);
        }

        if(size>capacity){
            hashMap.remove(removeTail());
            size--;
        }
    }

    //从头部插入节点
    public void addHead(Node node) {
        hashMap.put(node.key,node);
        dummyHead.next.pre = node;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
    }

    //从尾部删除节点
    public Node removeTail() {
        return removeNode(dummyTail.pre);
    }

    //将节点移到最前面
    public void moveToHead(Node node) {
        addHead(node);
        removeNode(node);
    }

    //移出节点
    public Node removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

}
