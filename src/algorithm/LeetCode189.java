package algorithm;

import java.util.Arrays;

//189.轮转数组
public class LeetCode189 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public static void rotate(int[] nums, int k) {
        /**
         * 思路：
         * 借助另一个数组，对于原数组中的第i个数，其轮转后的位置就是（i+k）%数组长度
         */

        int[] newNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k)%nums.length] = nums[i];
        }

        System.arraycopy(newNums,0,nums,0,nums.length);
    }
}
