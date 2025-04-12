package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

//225.用队列实现栈
public class LeetCode225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());
    }



}


class MyStack {
    /**
     * 思路：
     * 这里不能像用两个栈实现队列那样，一个作为输入队列，另一个作为输出队列
     * 因为将一个队列中的元素倒到另一个队列中实际上元素的顺序还是没变。
     * 这里的真正做法是将一个队列作为另一个队列的备份队列，比如队列1用来接收输入的元素
     * 当栈要弹出栈顶的元素时，就先将队列1队列尾部前的所有元素备份到队列2，然后弹出队列1的尾部元素
     * 弹出完成后就将队列2备份的元素重新放回队列1
     */

    //主队列
    private Queue<Integer> mainQueue;
    //备份队列
    private Queue<Integer> backupQueue;

    public MyStack() {
        mainQueue = new ArrayDeque<>();
        backupQueue= new ArrayDeque<>();
    }

    public void push(int x) {
        mainQueue.add(x);
    }

    public int pop() {
        backup();
        Integer poll = mainQueue.poll();
        load();
        return poll;
    }

    public int top() {
        backup();
        Integer peek = mainQueue.peek();
        load();
        return peek;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    /**
     * 将主队列尾部前的元素备份到备份队列
     */
    private void backup(){
        int size = mainQueue.size();
        //这里踩了一个坑，由于mainQueue的长度每次循环后都会-1，因此如果在for循环中一直用size方法来获取长度，那这个长度就不是第一次获取的长度了，它会一直变小，导致中间有些元素没有被备份到备份队列中
//        for (int i = 0; i <mainQueue.size()-1; i++) {
        for (int i = 0; i < size-1; i++) {
            backupQueue.add(mainQueue.poll());
        }
    }

    /**
     * 将备份队列的元素重新加载到主队列
     */
    private void load(){
        Queue<Integer> tmp;
        if(mainQueue.isEmpty()){
            tmp = mainQueue;
            mainQueue = backupQueue;
            backupQueue = tmp;
        }else {
            backupQueue.add(mainQueue.poll());
            tmp = mainQueue;
            mainQueue = backupQueue;
            backupQueue = tmp;
        }
    }
}
