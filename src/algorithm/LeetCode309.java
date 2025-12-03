package algorithm;

//309.买卖股票的最佳时机含冷冻期
public class LeetCode309 {

    public int maxProfit(int[] prices) {
        /**
         * 这题可以定义四个状态，dp[i][1~4]
         * 1.今天持有股票
         * 2.今天因卖出股票而处于不持有股票状态
         * 3.今天延续前一天的不持有股票状态
         * 4.今天处于冷冻期
         */

        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = 0;
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(Math.max(dp[i - 1][3] - prices[i], dp[i - 1][4] - prices[i]), dp[i - 1][1]);
            dp[i][2] = dp[i - 1][1] + prices[i];
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][4] = dp[i - 1][2];
        }

        return Math.max(Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]), dp[prices.length - 1][4]);
    }

}
