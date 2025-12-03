package algorithm;

import java.util.Arrays;

//169.多数元素
public class LeetCode169 {

    public int majorityElement(int[] nums) {
        /**
         * 官解
         * 如果一个数字出现的次数超过所有数字个数的一半，那么将这个数组排序后，该数字一定会出现在下标n/2处。
         */
        int index = nums.length / 2;
        Arrays.sort(nums);
        return nums[index];
    }
}
