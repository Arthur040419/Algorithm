package algorithm;

//518.零钱兑换II
public class LeetCode518 {

    public int change(int amount, int[] coins) {
        /**
         * 思路：完全背包问题，总金额可以看成背包容量，每种硬币可以看成要放入背包的物品
         * 1.定义dp数组，dp[i][j]表示用前i种硬币组合成j价值共有多少种组合方法
         * 2.确定状态转移方程
         *   如果用当前这枚硬币，那么组合数就是dp[i][j-value[i]]
         *   如果不用当前这枚硬币，那么组合数就是dp[i-1][j]
         *   最终组合数就是这两个结果相加
         * 3.初始化dp数组，对于第1枚硬币，也就是dp[0][j]，如果价值能被面值整除，组合数就为1，否则为0
         *               如果价值为0，也就是dp[i][0]，那么组合数永远为1，即用任何硬币都可以组合成价值为0的结果，也就是不放硬币（这里是个坑点，我原本这里初始化的为0）
         *
         * 4.确定遍历顺序
         *   从状态转移方程不难得知，dp[i][j]由上方和左方的值推导而来，所以遍历顺序为从左到右，从上到下
         */

        //定义dp数组
        int[][] dp = new int[coins.length][amount + 1];

        //初始化
        for (int i = 0; i < amount + 1; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        //遍历数组
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

}
