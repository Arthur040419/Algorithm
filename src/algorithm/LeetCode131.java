package algorithm;

import java.util.ArrayList;
import java.util.List;

//131.分割回文串
public class LeetCode131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;

    }

    private void backtracking(String s, int begin) {
        /**
         * 思路：
         * 用begin代表待分割范围的起点
         * 每次分割选择begin后面的一个数end，判断[begin,end]这个范围的字符串是否为回文串，分割范围本题采用包前包后
         * 如果是，就继续分割end后面的数，如果不是，直接返回
         * 终止条件：
         * 当begin>=字符串s的长度时，代表已经分割完毕
         */

        if(begin>=s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String subString = s.substring(begin,i+1);
            if(isTrue(subString)){
                path.add(subString);
                backtracking(s,i+1);
                //回溯
                path.remove(path.size()-1);
            }
        }

    }

    //判断是否为回文
    private boolean isTrue(String subString) {
        boolean flag = true;
        int left = 0;
        int right = subString.length()-1;
        while (left<right){
            if(subString.charAt(left)!=subString.charAt(right)) flag = false;
            left++;
            right--;
        }
        return flag;
    }
}
