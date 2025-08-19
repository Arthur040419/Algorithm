package algorithm;

//53.最大子数组和
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        /**
         * 思路：
         * 这题可以使用贪心
         * 贪心点在于：当目前的连续数组和小于0时，那么认为这个连续数组必然会使后面的连续数组的值减小，所以放弃当前的连续数组，直接取下一个值
         */

        int result = Integer.MIN_VALUE;
        //目前的连续数组和
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result = Math.max(result, count);
            if (count < 0) count = 0;
        }

        return result;
    }

    //复习
    public int maxSubArray_Review(int[] nums) {
        int result = Integer.MIN_VALUE;
        //当前的子数组之和
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            result = Math.max(result, curSum);
            if (curSum < 0) curSum = 0;
        }
        return result;
    }
}
