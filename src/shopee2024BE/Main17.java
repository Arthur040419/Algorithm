package shopee2024BE;

import java.util.Deque;
import java.util.LinkedList;

//Shopee2024提前批BE笔试题第17题，压缩字符串（一）
public class Main17 {
    public String compressString (String param) {
        /**
         * 思路：
         * 使用栈进行字符匹配
         * 遍历param中的每一个字符
         * 如果栈顶元素与当前字符相同，那么计数count+1
         * 如果不相同，那么弹出栈顶元素，并将当前字符存入栈，重置count为1
         */
        if(param.length()==0) return "";
        Deque<Character> stack = new LinkedList<>();
        //初始化栈
        stack.push(param.charAt(0));
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 1; i < param.length(); i++) {
            if(param.charAt(i)==stack.peek()){
                count++;
            }else {
                //弹出栈顶元素
                Character top = stack.pop();
                stack.push(param.charAt(i));
                if(count!=1)res.append(""+top+count);
                else res.append(""+top);
                count=1;

            }

        }
        //处理最后一个字符
        Character top = stack.pop();
        if(count!=1) res.append(""+top+count);
        else res.append(""+top);
        return res.toString();
    }

}
