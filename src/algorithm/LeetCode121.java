package algorithm;

//121.买卖股票的最佳时机
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        /**
         * 思路：贪心
         * 依次遍历数组，逐步更新当前的股票的最低价格和最高价格
         * 一旦最低价格发生变化，先结算前面找到的最高价和最低价能赚的钱，如果更高就更新最终答案，然后将最高价格也一起发生变化。
         */

        if(prices.length==0){
            return 0;
        }

        int ans = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                ans = Math.max(ans,max-min);
                min = prices[i];
                max = prices[i];
            } else {
                max = Math.max(max, prices[i]);
            }
        }
        ans = Math.max(ans, max - min);
        return ans;
    }

}
