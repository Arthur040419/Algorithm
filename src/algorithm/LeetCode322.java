package algorithm;

//322.零钱兑换
public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];       //dp[i]表示凑成i原所需的最少硬币数,-1表示无法凑成
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    //复习-2025-11-7
    public int coinChange_Review(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {      //这里要注意有两个条件，复习的时候漏了第二个条件
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

}
