package algorithm;

//198.打家劫舍
public class LeetCode198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];        //dp[i]表示仅偷前n家最多能偷多少钱
        for (int i = 1; i < nums.length; i++) {
            if(i>1){
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }else {
                dp[i] = Math.max(nums[i],dp[0]);
            }
        }
        return dp[nums.length-1];
    }

}
