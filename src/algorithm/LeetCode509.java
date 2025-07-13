package algorithm;

//509.斐波那契数
public class LeetCode509 {
    public int fib(int n) {
        /**
         * 思路：
         * 动态规划经典题
         * 1.确定dp数组,dp[i]代表第i个斐波那契数为dp[i]
         * 2.确定状态转移公式，dp[i]=dp[i-1]+dp[i-2]
         * 3.初始化dp数组 dp[0]=0 dp[1]=1
         * 4.确定dp数组遍历顺序：从前往后遍历
         */

        //确定dp数组
        int[] dp = new int[n+1];

        //初始化dp数组,这里有个细节，需要考虑n小于1这些情况
        if(n>=0) dp[0]=0;
        if(n>=1) dp[1]=1;

        //遍历dp数组
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
