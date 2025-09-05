package algorithm;

//35.搜索插入位置
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        /**
         * 思路：
         * 简单的二分查找
         */
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[begin] < target ? begin + 1 : begin;
//        return nums[end] < target ? end + 1 : end;         这种不行，会有数组越界。

    }

}
