package qiniu;

//2025七牛笔试第三题
public class Main3 {
    public int[] findStrongestSquad (int[] powers) {
        //定义dp数组,dp[i][j]代表从第i个士兵到第j个士兵中能否组成最强小队，1表示能，0表示不能
        int[][] dp = new int[powers.length][powers.length];
        //maxDp表示最强小队中的最大力量值
        int[][] maxDp = new int[powers.length][powers.length];
        //minDp表示最小力量值
        int[][] minDp = new int[powers.length][powers.length];

        int maxLen = 0;
        int minPower = Integer.MAX_VALUE;

        return null;
    }
}
