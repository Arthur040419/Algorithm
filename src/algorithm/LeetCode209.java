package algorithm;

//长度最小的子数组
public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        System.out.println(minSubArrayLen(7, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        //思路：滑动窗口
        int rs = Integer.MAX_VALUE;
        //滑动窗口前面的指针
        int fast = 0;
        //滑动窗口后面的指针
        int slow = 0;
        //子数组的和
        int sum = 0;
        for (fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                int subLength = fast - slow + 1;
                rs = rs < subLength ? rs : subLength;
                sum-=nums[slow++];
            }
        }
        if(rs==Integer.MAX_VALUE) return 0;
        return rs;
    }
}
