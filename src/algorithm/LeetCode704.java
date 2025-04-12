package algorithm;

//二分查找
public class LeetCode704 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        if(target<nums[0]||target>nums[nums.length-1]){
            //避免目标不不在数组内的时候还仍然跑到数组里去找
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int rs = -1;
        //如果左边索引已经超过右边索引就退出循环
        while (left <= right) {
            if (nums[mid] == target) {
                rs = mid;
                break;
            } else {
                if (nums[mid] < target) {
                    //说明目标值在右半部分
                    left = mid + 1;
                } else {
                    //说明目标值在左半部分
                    right = mid - 1;
                }
            }
            mid = (left + right) / 2;
        }
        return rs;
    }
}
