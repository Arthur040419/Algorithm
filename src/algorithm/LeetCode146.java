package algorithm;

import java.util.HashMap;
import java.util.Map;

//146.LRU缓存
public class LeetCode146 {

}

class LRUCache{

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    Map<Integer,DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;
    int size;           //实际大小
    int capacity;       //容量

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();   //虚拟头节点
        tail = new DLinkedNode();   //虚拟尾节点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //先判断缓存是否存在
        if(cache.containsKey(key)){
            //将该节点提到最前面
            DLinkedNode dLinkedNode = cache.get(key);
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        //判断节点是否存在
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode==null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            //添加节点到最前面
            addToHead(newNode);
            size++;
            //计算当前大小是否超出容量
            if(size>capacity){
                //移除末尾节点
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        }else {
            //更新节点值
            dLinkedNode.value = value;
            //将节点移到最前面
            moveToHead(dLinkedNode);
        }

    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
