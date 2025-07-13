package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90.子集II
public class LeetCode90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
         * 思路：
         * 这题就是在LeetCode78求子集的基础上加上去重
         * 去重逻辑和LeetCode40相似，去重的步骤如下：
         * 1.对数组进行排序，用一个used数组标记第i个元素是否已经被使用过
         * 2.遍历数组中的元素，如果遍历到的元素与前一个元素相等，并且前一个元素没有被使用过，则认为以该元素开始的子集就是重复子集
         * 3.如果遍历到的元素与前一个元素相等，并且前一个元素已经被使用过了，则认为不是重复子集，而认为这两个元素是属于同一个子集
         */

        //对数组排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, 0, used);
        return result;
    }

    private void backtracking(int[] nums, int begin, boolean[] used) {
        result.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1, used);
            //回溯
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }
}