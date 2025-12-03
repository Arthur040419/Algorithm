package algorithm;

//213.打家劫舍II
public class LeetCode213 {

    public static void main(String[] args) {
        LeetCode213 test = new LeetCode213();
        System.out.println(test.rob(new int[]{1, 3, 1, 3, 100}));
    }

    public int rob(int[] nums) {
        /**
         * 这题和打家劫舍I的不同点在于现在首尾房屋是相连的
         * 所以此时，要么偷第一间房，不偷最后一间，也就是只考虑第一间到倒数第二间
         * 要么偷最后一间，不偷第一间，也就是只考虑第二间到最后一间
         * 此时问题就转化成了打家劫舍I的问题。
         * 只需要取两种情况的最大值即可
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        //情况1
        int[] dp1 = new int[nums.length + 1];

        for (int i = 2; i < nums.length + 1; i++) {
            if (i > 2) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
            } else {
                dp1[i] = nums[i - 1];
            }
        }

        //情况2
        int[] dp2 = new int[nums.length + 1];

        for (int i = 1; i < nums.length; i++) {
            if (i > 1) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
            } else {
                dp2[i] = nums[i - 1];
            }
        }

        return Math.max(dp1[nums.length], dp2[nums.length - 1]);
    }
}
