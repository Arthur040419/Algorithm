package algorithm;

import java.util.Stack;

//232.用栈实现队列
public class LeetCode232 {
    /**
     * 本题不涉及什么算法，主要要熟悉掌握队列和栈这个数据结构的使用
     */
}

class MyQueue {

    //输入栈
    private Stack<Integer> stackIn;
    //输出栈
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        //首先要确定输出栈是否为空，不为空才能弹出栈顶元素，为空需要将输入栈内容全部倒入输出栈
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }

    private void dumpStackIn() {
        if(!stackOut.isEmpty()){
            return;
        }else{
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }

    }
}
