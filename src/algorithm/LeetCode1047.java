package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//1047.删除字符串中的所有相邻重复项
public class LeetCode1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    //耗时33ms
    public static String removeDuplicates(String s) {
        /**
         * 思路与下面一致，不过这里可以直接用字符串作为栈，省去了转换字符串的操作
         */
        StringBuffer result = new StringBuffer();
        //top代表result的最后一个字符的索引
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(result.length()<=0||result.charAt(top)!=c){
                result.append(c);
                top++;
            }else if(result.charAt(top)==c){
                result.deleteCharAt(top);
                top--;
            }
        }
        return result.toString();
    }

    //耗时110ms
    public static String removeDuplicates_My(String s) {
        /**
         * 思路：
         * 遍历字符串s，每遍历一个字符就将字符存入栈
         * 如果当前字符与栈顶字符相同，则弹出栈顶元素
         * 当遍历完字符串后，栈内剩余所有字符就是最终结果
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
