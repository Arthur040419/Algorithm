package qiniu;

import java.util.ArrayDeque;
import java.util.Deque;

//2025七牛笔试第二题
public class Main2 {
    public int calculate (String expr) {
        // write code here
        String[] express = null;
        int result = 1;
        if(expr.contains("x")){
            String[] split = expr.split("x");
            express = split;
            for (int i = 0; i < express.length; i++) {
                result*=handleExpress(express[i]);
            }
        }else {
            result = handleExpress(expr);
        }
        return result;
    }

    public int handleExpress(String express){
        int result = 0;
        if(express.contains("#")){
            String[] split = express.split("#");
            for (int i = 0; i < split.length; i++) {
                result += Integer.valueOf(split[i]);
            }
        }else {
            result = Integer.valueOf(express);
        }

        return result;
    }


}
