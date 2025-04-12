package test;

import java.util.ArrayDeque;
import java.util.Queue;

public class TEST {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        //添加元素到队列
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);

        //移除并返回队列头部的元素
        Integer element1 = queue.poll();
        Integer element2 = queue.remove();
        System.out.println("获取到的元素" + element1 + " " + element2);
        System.out.println(queue);

        //返回队列头部的元素但不删除
        element1 = queue.peek();
        element2 = queue.element();
        System.out.println("获取到的元素" + element1 + " " + element2);
        System.out.println(queue);

        //判断队列是否为空
        System.out.println(queue.isEmpty());

        //返回队列中元素个数
        System.out.println(queue.size());

        //清空队列
        queue.clear();
        System.out.println(queue);


    }
}
