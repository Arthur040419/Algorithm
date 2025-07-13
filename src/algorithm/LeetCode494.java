package algorithm;

//494.目标和
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 思路：这道题也可以转换成背包问题
         * 给每一个数前面添加正号+或符号-，其实就是将整个数组分成了两部分，最终结果就是这两部分相减
         * 因此可以得出这个公式，left-right = target left就是被添加了+号的数的集合，right就是被添加了-号的数的集合
         * 又由于 right = sum - left ，sum就是整个nums数组之和，可以推出 left = target + sum - left
         * 进一步推出 left = (sum+target)/2，也就是说如果要符合题意，那么被分配+号的数的和一定等于left
         * 所以，题目最终就转化成了，使用nums中的数来填满容量为left的背包共有几种方法。
         *
         * 1.定义dp数组，dp[i][j]表示使用前i个数来填满容量为j的背包的方法数
         * 2.写出递推公式，对于第i个数，可以选择放或不放
         * 如果选择放，那么填满背包的方法数就是dp[i-1][j-nums[i]]
         * 如果选择不妨，那么填满背包的方法数就是dp[i-1][j]
         * 所以用前i个物品填满容量为j的背包总的方法数就是上面两种情况的方法数之和，即递推公式为：dp[i][j] = dp[i-1][j-nums[i]]+dp[i-1][j]
         * 3.初始化dp数组
         * 由于dp[i][j]依赖于其左上角和正上方的两个数，因此第一行和第一列一定要先初始化
         * 对于第一行，当前仅当背包容量等于第0个数的值时,dp[i][j]=1，其他情况dp[i][j] = 0
         * 对于第一列，按理来说，dp[i][0]应该都为1，也就是不需要放任何数字，背包就被填满了
         * 但是题目要求nums可能存在 数字0，所以，dp[i][0]= 2的n次方 n为前i个数中 数字0的个数。
         *
         * 4.确定遍历顺序
         * 遍历顺序为从上到下，从左到右
         */

        //计算sum
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }

        //计算left
        int left = 0;
        if((sum+target)%2==1){
            //如果为奇数，无解，因为，nums的数字都为整数，因此left的值不可能为奇数
            return 0;
        }else {
            left = (sum+target)/2;
        }

        //如果target的绝对值已经大于sum了，也无解
        if(Math.abs(target)>Math.abs(sum)){
            return 0;
        }

        
        //定义dp数组
        int[][] dp = new int[nums.length][left+1];
        
        //初始化dp数组
        //初始化第一行
        if(nums[0]<=left) dp[0][nums[0]] = 1;
        //初始化第一列
        int zeroCount = 0;      //记录前i个数中0的个数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) zeroCount++;
            dp[i][0] = (int) Math.pow(2,zeroCount);
        }
        
        //遍历dp数组
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < left+1; j++) {
                //这里要注意看nums[i]的值是否大于背包容量j
                if(nums[i]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][left];
    }
}
