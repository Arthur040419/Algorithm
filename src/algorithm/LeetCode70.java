package algorithm;

//70.爬楼梯
public class LeetCode70 {
    public int climbStairs(int n) {
        /**
         * 思路：
         * 和斐波那契数一样，都是经典的动态规划题目
         * 1.定义dp数组,dp[i]代表爬到第i阶的方法数
         * 2.确定状态转移方程，dp[i]=dp[i-1]+dp[i-2]
         * 3.初始化dp数组,dp[0]=1,dp[1]=1或者不管dp[0]，直接dp[1]=1 dp[2]=2
         * 4.确定遍历顺序，从前往后遍历
         */

        //定义dp数组
        int[] dp = new int[n + 1];

        //初始化dp数组，这里的这个细节在前面做斐波那契数的时候已经体验过了
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        //遍历dp数组
        for (int i = 3; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
