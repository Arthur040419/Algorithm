package algorithm;

//416.分割等和子集
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        /**
         * 思路：实际上是背包问题（滚动数组）
         * 要将数组分割成两个子集，并且两个子集和要相等，那这个值其实就是整个数组的和的一半嘛
         * 所以题目也就转化成了是否存在一个子集的和为整个数组和的一半
         * 然后这个问题又可以转换成背包问题，背包容量为数组和的一半，物品的重量weight和价值value都是数组中每一个元素的值
         * 也就是判断dp[n]的最大值是否能够等于数组和的一半，n就是背包容量，大小也为数组和的一半
         */


        //计算数组的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        //如果是奇数，直接返回false
        if(sum%2==1) return false;

        //定义dp数组
        int[] dp = new int[sum/2+1];

        //初始化dp数组
        dp[0] = 0;

        //遍历dp数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum/2; j > 0; j--) {
                if(j-nums[i]>=0) dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        if(dp[sum/2]==sum/2) return true;

        return false;
    }
}
