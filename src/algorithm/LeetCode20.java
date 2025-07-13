package algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//20.有效的括号
public class LeetCode20 {

    public boolean isValid(String s) {
        /**
         * 思路与下面的一样，但是这里是技巧版的
         * 与原本不同，原本是遇到左括号就将其入栈，现在是遇到左括号就将其对应的右括号入栈
         * 如：当前元素为'(' 就将')'入栈，当前元素为'['就将']'入栈
         * 这样的好处就是在遍历到右括号时可以直接比较当前元素与栈顶元素是否相等，如果相等说明匹配成功，不相等说明匹配失败。
         * 代码会好写很多
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遍历到左括号时直接将其对应的右括号入栈
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }

            //遍历到右括号时直接然其与栈顶元素比较
            if(c==')'||c==']'||c=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(c!=stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid_My(String s) {
        /**
         * 思路：栈的经典应用
         * 遍历字符串s
         * 如果是左括号就入栈
         * 如果是普通字符就不管
         * 如果是右括号就弹出栈顶元素
         * 然后将栈顶元素与当前遍历到的元素比较
         * 判断字符串无效有如下3种情况：
         * 1.遍历过程中弹出的栈顶元素与当前元素不匹配，说明字符串无效
         * 2.遍历过程中栈为空，说明右括号多余了，字符串无效
         * 3.遍历完后，栈中还有元素，说明左括号多余了，字符串无效
         *
         * 判断字符串有效的情况：
         * 遍历完字符串且栈元素为空
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character element = stack.pop();
                if (c == ')' && element != '(') {
                    return false;
                } else if (c == ']' && element != '[') {
                    return false;
                } else if (c == '}' && element != '{') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            //栈不为空，说明左括号多余了
            return false;
        }
        return true;
    }

    //复习
    public boolean isValid_My1(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(s.charAt(i)=='('){
                stack.push(')');
            }else {
                if(stack.isEmpty()||stack.pop()!=s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }

}
