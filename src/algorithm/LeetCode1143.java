package algorithm;

public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 思路：二维动态规划
         *
         * 1.定义dp数组
         * dp[i][j] 表示text1的0-i的子串与text2的0-j的子串的最长公共子序列的长度
         *
         * 2.初始化dp数组
         * 当任意字符串的长度为0时，公共子序列一定为0，因此可以初始化dp[0][j] = 0,dp[i][0]=0;
         *
         * 3.确定状态转移方程
         * 第一种情况：当text1的第i个字符与text2的第j个字符相同时，那么此时dp[i][j] = dp[i-1][j-1]+1
         * 第二种情况：当text1的第i个字符与text2的第j个字符不相同时，就取dp[i-1][j]和dp[i][j-1]中的最大值
         */

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < text2.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


}
