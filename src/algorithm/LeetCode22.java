package algorithm;

import java.util.ArrayList;
import java.util.List;

//22.括号生成
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        /**
         * 思路：最能直接想到的就是暴力生成所有可能的情况，然后一个一个判断是否合法。
         * 基于这种思路，可以优化一下，即在添加括号时，当且仅当当前的组合合法时才继续添加括号，否则不在继续添加
         */

        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(),0,0,n,ans);
        return ans;
    }


    public void backtrack(StringBuilder str, int left, int right, int n, List<String> ans) {
        if (str.length() == 2 * n) {
            ans.add(str.toString());
            return;
        }

        if(left<n){
            str.append("(");
            backtrack(str,left+1,right,n,ans);
            str.delete(str.length()-1,str.length());
        }

        if(right<left){
            str.append(")");
            backtrack(str,left,right+1,n,ans);
            str.delete(str.length()-1,str.length());
        }
    }
}
