package algorithm;

import java.util.Deque;
import java.util.LinkedList;

//394.字符串编码
public class LeetCode394 {

    public String decodeString(String s) {
        /**
         * 思路：
         * 遍历s的每一个字符
         * 每次遇到 ] 就依次取出栈顶元素，用一个临时字符串tmp存储，直到遇到 [，
         * 接着如果栈顶元素是数字n，就将tmp重复n次压入栈中，如果不是数字，直接将tmp压入栈中一次。
         * 如果不是 ] 就将其压入栈中
         * 最终s的每一个字符遍历完毕后，就取出栈内所有所有元素并反转就是最终编码后的结果
         */

        Deque<String> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (c.equals("]")) {
                StringBuilder tmp = new StringBuilder();
                Integer repeat = 1;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (!pop.equals("[")) {
                        tmp.append(pop);
                    } else {
                        String num = stack.peek();
                        if ('0' <= num.charAt(0) && num.charAt(0) <= '9') {
                            repeat = Integer.valueOf(num);
                            stack.pop();
                        }
                        break;
                    }
                }
                for (int j = 0; j < repeat; j++) {
                    stack.push(tmp.toString());
                }
            } else if ('0' <= c.charAt(0) && c.charAt(0) <= '9') {
                //数字可能不止一位
                number.append(c);
            } else {
                if (!number.isEmpty()) {
                    stack.push(number.toString());
                    number.delete(0, number.length());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

}
