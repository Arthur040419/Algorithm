package algorithm;

//153.寻找旋转排序数组中的最小值
public class LeetCode153 {

    public static void main(String[] args) {
        //生成测试用例
//        int[] nums = {3,4,5,1,2};
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {11,13,15,17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        /**
         * 思路：与LeetCode33思路差不多，二分查找可以用于查找非有序序列，但是该序列必须是由两个有序序列组合而成，如4、5、6、7、0、1、2
         * 但是这题不是找目标值，而是找序列中的最小值，所以稍微有些不同
         * 假设搜索范围为[left,right]，还是先找到mid
         * 此时可以先判断left到mid之间是不是有序的，如果是，那么我们可以先将left所对应的值记录一下，作为备选答案ans，因为如果是有序的，说明在[left,mid]这个范围内，nums[left]一定是最小的。
         * 接着继续到[mid+1,right]区间中去找最小值
         * 如果不是有序的，可以先记录mid的值，将其与目前的备选答案ans对比取较小值，然后接着去[left,mid-1]区间去找最小值。
         * 最终ans就是整个序列的最小值
         */

        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[left]<=nums[mid]){
                ans = Math.min(ans,nums[left]);
                left = mid+1;
            }else {
                ans = Math.min(ans,nums[mid]);
                right = mid-1;
            }
        }

        return ans;

    }

}
