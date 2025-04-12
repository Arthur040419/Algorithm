package algorithm;

import java.util.Arrays;

//移除元素
public class LeetCode27 {
    public static void main(String[] args) {
        System.out.println(removeElement_My(new int[]{1}, 1));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        //学到的思路，快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static int removeElement_My(int[] nums, int val) {
        //相向双指针
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == val) right--;       //从右往左找到第一个非val值
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
                //如果是我，我会在这里写个count++，完全不会去想用left指针作为返回值
                //count++
            }
            left++;
            while (right >= 0 && nums[right] == val) right--;
        }
        //直接将索引作为返回值，不像我还得拿个什么count变量来记录
        return left;
    }

    public static int removeElementWithFastSlowIndex(int[] nums, int val) {
        //快慢指针法-这里是后面又来自己写了一遍代码
        /**
         * 快慢指针思路：
         * 快慢指针同时出发
         * 如果快指针所在位置的值与目标值不同，就交换快慢指针的值，并将快慢指针同时向前移动
         * 如果快指针所在位置的值与目标值相同，就只移动快指针，慢指针不动
         */
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                //这里可以直接将快指针的值给到慢指针，因为题目又说，只管前面的数据，最后面是啥不管
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}