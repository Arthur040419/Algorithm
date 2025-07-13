package algorithm;

//122.买卖股票的最佳时机II
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        /**
         * 思路：
         * 这道题的贪心点在于，只要利润是正利润，那就是买卖股票的最佳时机
         * 因此对于prices数组，可以先获取相邻元素的差（也就是两天之间的利润）
         * 只要利润是正数，就将其累加到结果中
         */

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) result += profit;
        }
        return result;
    }
}
