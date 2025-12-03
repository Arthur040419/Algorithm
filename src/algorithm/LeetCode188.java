package algorithm;

//188.买卖股票的最佳时机IV
public class LeetCode188 {

    public int maxProfit(int k, int[] prices) {

        /**
         * 思路和买卖股票的最佳时机III很相似
         */

        //定义dp数组
        /**
         * dp[i][1]表示第一次持有股票
         * dp[i][2]表示第一次不持有股票
         * dp[i][3]表示第二次持有股票
         * dp[i][4]表示第二次不持有股票
         * 奇数表示持有股票，偶数表示不持有股票
         */
        int[][] dp = new int[prices.length][2 * k + 1];

        //初始化
        dp[0][0] = 0;
        for (int i = 1; i < 2 * k + 1; i++) {
            if (i % 2 != 0) {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                }
            }
        }

        return dp[prices.length - 1][2 * k];
    }

}
