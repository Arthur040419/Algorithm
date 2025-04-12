package algorithm;

import java.util.*;

//150.逆波兰表达式求值
public class LeetCode150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        /**
         * 思路：又一个栈的经典应用
         * 遍历tokens中的每一个字符
         * 如果当前字符为数字就直接压入栈中
         * 如果当前字符为运算符，就从栈中弹出两个元素进行运算，然后将运算结果再压入栈中
         * 当遍历完所有字符时，栈中剩下最后一个数字就是逆波兰表达式的结果
         */
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String exp3 = tokens[i];
            //注意先弹出的数字应该是作为减数和除数，后弹出的数组作为被减数和被除数
            if (exp3.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (exp3.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (exp3.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (exp3.equals("/")) {
                int exp1 = stack.pop();
                int exp2 = stack.pop();
                stack.push(exp2 / exp1);
            } else {
                stack.push(Integer.valueOf(exp3));
            }
        }
        return stack.pop().intValue();
    }
}
