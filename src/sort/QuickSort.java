package sort;

import java.util.Arrays;

//快速排序
public class QuickSort {

    public static void quickSort(int[] nums, int i, int j) {
        /**
         * 思路：
         * 快排的基本思路：从待排序的数组中随机选择一个元素作为基准值，然后遍历数组中的其他元素，如果比基准值大就将其放到基准值的右边，反之放到基准值的左边
         * 遍历完毕后，数组就被基准值分成了两部分，一部分全部小于基准值，另一部分全部大于基准值
         * 接着只需对这两部分递归进行快速排序，直到最终整个数组排序完成
         *
         * 快速排序的代码有很多种实现方式：
         * 1.hoare
         * 选取最左边或最右边的元素为基准值，这里以选取最右边的元素为例
         * 定义两个指针left、right分别指向数组最开始的位置和右边基准值的前一个位置
         * 首先移动left指针，如果left指向的元素小于基准值，那么left就向后移动，反之，left就停止移动
         * left停止移动后，就再移动right，如果right指向的元素大于基准值，right就向前移动，反之，right就停止移动
         * 当right停止移动时，就交换left、right所指向的元素
         * 重复执行上面的操作，直到left==right
         * 当遍历完基准值以外的所有元素后，还需要将基准值与left指向的位置进行交换
         *
         */

        if (i >= j) {
            return;
        }

        //基准值
        int standard = nums[j];
        int left = i;
        int right = j;
        while (left < right) {
            while (left < right && nums[left] <= standard) {
                left++;
            }
            while (left < right && nums[right] >= standard) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        nums[j] = nums[left];
        nums[left] = standard;

        quickSort(nums, i, left - 1);
        quickSort(nums, left + 1, j);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 4, 6, 2, 3, 5, 8, 7,2};
        int[] nums = new int[]{1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
