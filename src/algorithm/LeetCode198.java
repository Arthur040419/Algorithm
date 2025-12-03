package algorithm;

//198.打家劫舍
public class LeetCode198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];        //dp[i]表示仅偷前n家最多能偷多少钱
        for (int i = 1; i < nums.length; i++) {
            if (i > 1) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(nums[i], dp[0]);
            }
        }
        return dp[nums.length - 1];
    }

    //复习-2025-11-14
    public int rob_Review(int[] nums) {
        /**
         * 思路：对于每一家，要么偷，要么不偷。
         * 如果偷，那么前面一家就不能偷，所以能偷到的钱就是 dp[i-2]+nums[i]
         * 如果不偷，那么前面一家就可以偷，那偷到的钱就是dp[i-1]
         */

        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            if (i > 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            } else {
                dp[i] = nums[i - 1];   
            }
        }

        return dp[nums.length];
    }

}
