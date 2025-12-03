package algorithm;

//123.买卖股票的最佳时机III
public class LeetCode123 {

    public int maxProfit(int[] prices) {

        /**
         * 1.定义dp数组，dp[i][0~4]
         * 这里有5种状态
         * 0.第i天不做任何操作时的最大现金，啥都没做，没有买过卖过任何股票
         * 1.第i天第一次不持有股票时的最大现金
         * 2.第i天第一次持有股票时的最大现金
         * 3.第i天第二次不持有股票时的最大现金
         * 4.第i天第二次持有股票时的最大现金
         */
        int[][] dp = new int[prices.length][5];

        //2.初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = 0;   //第一天就买入并卖出
        dp[0][2] = -prices[0];  //第一天买入
        dp[0][3] = 0;   //第一天就买入并卖出，然后再买入再卖出
        dp[0][4] = -prices[0];  //第一天买入并卖出后，再买入

        /**
         * 3.状态转移方程
         * dp[i][0] = dp[i-1][0]
         * dp[i][1] = Max(dp[i-1][2]+prices[i],dp[i-1][1])    要么前一天第一次持有股票，然后今天卖掉；要么和前一天一样都是第一次不持有股票
         * dp[i][2] = Max(dp[i-1][0]-prices[i],dp[i-1][2])
         * dp[i][3] = Max(dp[i-1][2]+prices[i],dp[i-1][3])
         * dp[i][4] = Max(dp[i-1][1]-prices[i],dp[i-1][4])
         */

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][4] + prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][4]);
        }

        return dp[prices.length - 1][3];
    }

}
