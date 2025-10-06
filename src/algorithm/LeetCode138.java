package algorithm;

import java.util.HashMap;
import java.util.Map;

//138.随机链表的复制
public class LeetCode138 {

    //哈希表
    Map<Node,Node> map = new HashMap<>();

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        /**
         * 思路：
         * 递归（回溯）+哈希表
         * 对于每一个节点，我们只认为当该节点的next节点和random节点拷贝完成时，该节点才算拷贝完成。
         * 所以我们可以采用递归，拷贝一个节点时，递归地拷贝它地next节点和random节点。
         * 由于random节点是指向随机的节点，所以可能会有节点被多次拷贝，为了防止节点被多次拷贝，我们可以将已经完成拷贝的节点放到一个哈希表中
         * 在拷贝某个节点之前，先判断哈希表中是否已经存在拷贝完成的节点，如果存在直接取出，无需重复拷贝
         */

        //如果节点为空，无需拷贝
        if(head==null){
            return null;
        }

        if(!map.containsKey(head)){
            Node node = new Node(head.val);
            //拷贝节点一旦创建完成，立刻将其放入map集合
            map.put(head,node);
            //拷贝next节点
            node.next = copyRandomList(head.next);
            //拷贝random节点
            node.random = copyRandomList(head.random);
            //注意，应当在拷贝节点创建完成时就将其放到map集合中，因为在拷贝next，random节点时可能会有节点指向自己，所以不能等到节点完全拷贝完成后才将其放到map集合中
            //map.put(head,node);
            //这是递归终止条件，别忘了
            return node;
        }

        return map.get(head);

    }

    //复习-2025-09-17
    public Node copyRandomList_Review(Node head) {
        if(head==null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }

        Node newHead = new Node(head.val);
        map.put(head,newHead);
        //拷贝下一个节点
        newHead.next = copyRandomList_Review(head.next);
        //拷贝随机节点
        newHead.next = copyRandomList_Review(head.random);

        return newHead;
    }


}



