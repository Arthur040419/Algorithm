package algorithm;

//300.最长递增子序列
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];    //dp[i]表示以i为结尾的最长严格递增序列长度
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    result = Math.max(result,dp[i]);
                }
            }
        }
        return result;
    }

}
