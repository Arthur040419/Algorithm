package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47.全排列II
public class LeetCode47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //需要去重，先对数组排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used) {
        /**
         * 思路：
         * 去重还是通过used数组，判断同一层中是否出现重复的数字，如果出现，则说明排列重复了
         */
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && (i == 0 || nums[i] != nums[i - 1] || used[i - 1])) {
                path.add(nums[i]);
                used[i]=true;
                backtracking(nums,used);
                //回溯
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
