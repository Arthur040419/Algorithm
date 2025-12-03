package algorithm;

//279.完全平方数
public class LeetCode279 {

    public int numSquares(int n) {

        //dp[i]表示和为i的完全平方数的最小数量
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}
