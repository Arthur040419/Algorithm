import java.util.HashSet;
import java.util.Set;

public class Main11 {

    public static void main(String[] args) {
        /*
        # 给定一个整数数组 nums 和一个整数 K ，请你找到一个最长的连续子序列，使得该子序列中所有元素的和不超过 K ，并且该子序列中必须包含至少一个指定的元素 target 。
        # 输入：
        # • 一个整数列表 nums ，表示数组，数组里面每个数都>=0，可能重复。
        # • 一个整数 K ，表示子序列和的上限。
        # • 一个整数 target ，表示必须包含在子序列中的特定元素。
        # 输出：一个整数，表示最长的连续子序列的长度。如果不存在满足条件的子序列，返回 -1 。
        # 比如：
        # 输入：nums = [1, 2, 3, 0, 4, 5, 5]，K = 7，target = 3；
        # 输出： 4
        */

        /**
         * 思路：滑动窗口
         * 计算滑动窗口的总和sum，因为数组中所有数都是大于0的，所以滑动窗口的数字个数减少就代表sum减小，反之增大
         * 所以，当sum>k时，就移动left指针，left++
         * 当sum<k时，判断滑动窗口中是否有target值，如果有，就记录当前滑动窗口的长度，不断更新结果的最大值即可，然后移动right指针，right++。
         *
         *  边界条件：
         *  右指针到达数组结尾的时候。
         */

        int[] nums = {1, 2, 3, 0, 4, 5, 5};
        int k = 7;
        int target = 3;

        int left = 0;

        int res = -1;
        int sum = 0;
        int count = 0;      //count用来统计target值出现的次数

        //扩展右边界
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == target) {
                count++;
            }

            //不断缩小左边界
            while (left < i && sum > k) {
                if (nums[left] == target) {
                    count--;
                }
                sum -= nums[left++];
            }

            //更新长度
            if (sum <= k && count > 0) {
                res = Math.max(res, i - left + 1);
            }
        }

        System.out.println(res);
    }

}
