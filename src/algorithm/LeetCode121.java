package algorithm;

//121.买卖股票的最佳时机
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        /**
         * 思路：贪心
         * 依次遍历数组，逐步更新当前的股票的最低价格和最高价格
         * 一旦最低价格发生变化，先结算前面找到的最高价和最低价能赚的钱，如果更高就更新最终答案，然后将最高价格也一起发生变化。
         */

        if (prices.length == 0) {
            return 0;
        }

        int ans = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                ans = Math.max(ans, max - min);
                min = prices[i];
                max = prices[i];
            } else {
                max = Math.max(max, prices[i]);
            }
        }
        ans = Math.max(ans, max - min);
        return ans;
    }

    //复习-2025-11-24-动态规划
    public int maxProfit_Review(int[] prices) {
        //1.定义dp数组，dp[i][0]表示第i天持有股票时的最大现金，dp[i][1]表示第i天不持有股票时的最大现金
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        /**
         *2.定义状态转移方程
         *dp[i][0]=Max(dp[i-1][0],-prices[i])       要么是前一天就持有股票保留到今天，要么就是今天买的股票
         * dp[i][1]=Max(dp[i-1][1],dp[i-1][0]+prices[i])    要么是前一天你不持有股票保留到今天，要么就是今天卖掉股票
         */
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

}
