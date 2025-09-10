package algorithm;

//34.在排序数组中查找元素的第一个和最后一个位置
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        /**
         * 思路：
         * 官解，找到第一个等于目标值的位置leftIdx，以及第一个大于目标值的位置rightIdx
         * 最终[leftIdx,rightIdx-1]就是答案
         */
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx < 0 || rightIdx < 0 || leftIdx >= nums.length || rightIdx >= nums.length ||leftIdx>rightIdx){
            return new int[]{-1,-1};
        }
        return new int[]{leftIdx,rightIdx};
    }

    //lower为false表示查找第一个大于目标值的位置
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
