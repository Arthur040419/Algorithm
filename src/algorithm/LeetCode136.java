package algorithm;

//136.只出现一次的数字
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        /**
         * 官解思路：
         * 采用异或位运算，学会下面三个异或计算的性质：
         * 1.a^a=0
         * 2.a^0=a
         * 3.异或满足交换律和结合律
         *
         * 所以这道题要找到只出现一次的数，只需将所有的数进行异或运算，最终结果就是只出现一次的数
         * 因为出现两次的数在异或计算后都会变成0，最后由0与出现一次的数进行计算，所以最终结果就是只出现一次的数
         */
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans^=nums[i];
        }
        return ans;
    }


}
