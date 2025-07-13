package algorithm;

//560.和为k的子数组
public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        /**
         * 思路：滑动窗口
         * 左右指针分别指向子数组的首尾，
         * 当子数组的和大于k时，就将左指针向前移动，当子数组的和小于k时，就将右指针向前移动，当子数组和等于k时，结果+1
         */

        int result = 0;
        int left = 0;
        int right = 0;

        int sum = 0;
        while (left<nums.length){
            sum = 0;
            for (int i = left; i < right+1; i++) {
                sum+=nums[i];
            }

            if(sum==k){
                result++;
            }else if(left<right&&sum>k){
                left++;
            }else if(right<nums.length-1&&sum<k){
                right++;
            }else if(left==right&&sum>k){
                left++;
                right++;
            }
        }

        return result;
    }
}
