package algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139.单词拆分
public class LeetCode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //复习-2025-11-12
    public boolean wordBreak_Review(String s, List<String> wordDict) {
        /**
         * 思路：看成完全背包问题，字符串s作为要填充的背包，wordDict中的单词就是物品，单词可以重复放入
         */
        Set<String> set = new HashSet<>(wordDict);
        //dp[i]表示字符串s的前i个字符可以有字典中的单词表示
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if (set.contains(tmp) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
