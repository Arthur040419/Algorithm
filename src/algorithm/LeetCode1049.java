package algorithm;

//1049.最后一块石头的重量II
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        /**
         * 思路：
         * 可以想象一下这题的意思，两个石头相撞，如果它们重量相同，那两个石头都没了，如果重量不同，重量大的石头会减去重量小的石头的重量
         * 在这样一个情况下，如果要保证最后剩下的石头重量最小，就只需要尽可能将所有石头分成两堆，这两堆的重量尽量相等，这样一来，最后剩下的石头的重量也就尽可能的小了。
         * 所以这题其实也就转换成了背包问题，背包容量为所有石头总量的二分之一，向该背包放入石头，让放入石头的重量尽可能的大，石头就可以看作是重量和价值相等的物品
         */

        //计算石头的总重量
        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }

        //石头总重量的一半
        int target = sum/2;

        //定义dp数组
        int[] dp = new int[target+1];

        //初始化dp数组
        dp[0]=0;

        //遍历dp数组，背包问题，滚动数组的方式
        for (int i = 0; i < stones.length; i++) {
            //倒序遍历背包容量
            for (int j = target; j > 0; j--) {
                //别忘了判断j-stones[i]是否会小于0
                if(j-stones[i]>=0) dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum-2*dp[target];

    }

}
