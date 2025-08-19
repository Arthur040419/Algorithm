package algorithm;

import java.util.Arrays;

//238.除自身以外数组的乘积
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        /**
         * 思路：
         * 最简单的方法就是先算出所有元素的乘积，然后除以当前索引位置的元素。但是题目要求不能使用除法，所以这种方法不可行。
         * 第二种方法：
         * 对于第i个元素，除它以外所有元素的乘积可以用该元素左边所有元素的乘积 * 该元素右边素有元素的乘积
         * 用L[i]表示第i个元素左边所有元素的乘积，用R[i]表示第i个元素右边所有元素的乘积。
         * 这样一来，除第i个元素外，其他所有元素的乘积就可以表示成：L[i]*R[i]
         * 所以只需要提前填充好所有的L[i]和R[i]，就能得出最终结果。
         * 特别注意，当i等于0时，当前元素的左边并没有任何元素，所以L[0]可以初始化为1
         */

        //首先利用多层循环来填充L[i]和R[i]
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);

        //题目要求时间复杂度为n，这一块超时了
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                L[i] *= nums[j];
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                R[i] *= nums[j];
//            }
//
//        }

        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i-1]*nums[i-1];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            R[i] = R[i+1]*nums[i+1];
        }

        //计算结果
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = L[i] * R[i];
        }

        return result;

    }

}
