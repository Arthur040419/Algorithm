package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//17.电话号码的字母组合
public class LeetCode17 {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    //建立数字到字母的映射表
    private static final String[][] LETTER_MAP = {
            {}, //0
            {}, //1
            {"a","b","c"}, //2
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"},
    };
    public List<String> letterCombinations(String digits) {
        backtracking(digits,0);
        if(digits.length()==0) return Collections.emptyList();
        return result;
    }


    private void backtracking(String digits,int index) {
        //回溯终止条件：path的长度等于digits的长度
        if(path.length()==digits.length()){
            result.add(path.toString());
            return;
        }

        int num = digits.charAt(index)-'0';
        String[] arr = LETTER_MAP[num];
        for (int i = 0; i < arr.length; i++) {
            path.append(arr[i]);
            backtracking(digits,index+1);
            //回溯
            path.deleteCharAt(path.length()-1);
        }

    }
}
