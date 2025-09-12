package algorithm;

//33.搜索旋转排序数组
public class LeetCode33 {

    public int search(int[] nums, int target) {
        /**
         * 思路：
         * 我们直到二分查找法一般只能用在有序数组中，而旋转排序数组并不是有序数组。
         * 但是，旋转排序数组就是两个有序数组组合而来的，这样的话二分查找也能够使用，思路如下：
         * 对于范围为[left,right]的数组，找出中间索引mid
         * 此时数组就会被分成[left,mid-1]、[mid+1,right]两个部分
         * 那么这个时候可以先判断这两个数组哪一个是有序数组，因为旋转排序数组分成两半后一定有一半是有序的
         * 如果[left,mid-1]是有序的，那么就判断目标值是否在[left,mid-1]范围内，如果在就到该数组内去找，如果不在，就到[mid+1,right]中去找
         * 如果[mid+1,right]是有序的，那么还是判断目标值是否在该数组范围内，原理同上。
         */

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                //左半部分是有序的
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                //右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
