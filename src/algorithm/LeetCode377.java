package algorithm;

//377.组合总和
public class LeetCode377 {

    public int combinationSum4(int[] nums, int target) {
        /**
         * 思路：还是完全背包问题，不同点在于这题说如果元素的顺序不同则认为是不同的组合，这就很关键了
         * 对于排列问题，通常用一维数组来做
         * 对于组合问题，通常用二维数组来做
         * 因为二维数组通常会将可用元素限制在前i个，但对排列来说，元素是可以任意且无限次使用的，所以不大合适。
         */

        //1.定义dp数组,dp[i]表示结果为i的排列数
        //那么状态转移方程应该为dp[i] = dp[i-nums[0]]+dp[i-nums[1]]+...+dp[i-nums[n-1]]  (假设数组长度为n)
        int[] dp = new int[target + 1];

        //2.初始化dp数组
        dp[0] = 1;

        //3.遍历数组,这里注意，对于排列来说，应该是先遍历背包，再遍历“物品”，因为“物品”的存放顺序是任意的
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
