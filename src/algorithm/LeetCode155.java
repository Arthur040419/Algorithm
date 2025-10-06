package algorithm;

import java.util.Deque;
import java.util.LinkedList;

//155.最小栈
public class LeetCode155 {
    /**
     * 思路：
     * 利用辅助栈，核心思想是，基于栈的先进后出的特性，如果向栈内依次存入a、b、c、d，那么只要d还在栈顶，a、b、c就依然存在于栈内
     * 这样一来，每一个栈顶元素实际上都对应着一个最小值，这个最小值就是当本元素成为栈顶元素时，栈内所有元素的最小值。
     * 所以，每当存入一个元素时，都向辅助栈存入当前栈顶元素所对应的最小值，每次取最小值时就从辅助栈中获取最小值，栈顶元素出栈时，辅助栈对应的栈顶元素也出栈。
     */
}

class MinStack {

    Deque<Integer> mainStack = new LinkedList<>();
    Deque<Integer> supportStack = new LinkedList<>();

    public MinStack() {
        //初始化时向辅助栈中存入一个最大值
        supportStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        mainStack.push(val);
        supportStack.push(Math.min(val,supportStack.peek()));
    }

    public void pop() {
        mainStack.pop();
        supportStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }
}
