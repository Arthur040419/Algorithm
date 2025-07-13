package algorithm;

//746.使用最小花费爬楼梯
public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * 思路：
         * 1.定义dp数组，dp[i]表示到达第i阶台阶需要的最小花费
         * 2.定义状态转移方程，dp[i]=Min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
         * 3.初始化dp数组,dp[0]=0,dp[1]=1
         * 4.从2开始遍历
         */

        //定义dp数组
        int[] dp = new int[cost.length+1];

        //初始化dp数组
        dp[0]=0;
        dp[1]=0;

        //遍历dp数组
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
