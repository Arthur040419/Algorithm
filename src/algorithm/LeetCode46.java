package algorithm;


import java.util.ArrayList;
import java.util.List;

//46.全排列
public class LeetCode46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used) {
        /**
         * 思路：
         * 这题与组合问题的区别在于，排列中出现的元素是可以重复的，只要顺序不一样就属于不同的排列，比如[1,3,2]和[1,2,3]就属于不同的排列但属于相同的组合
         * 因此这里就不需要用begin来标记起始的位置了
         */

        //终止条件，当path的长度刚好为数组长度时就找到了一种排列
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums,used);
                //回溯
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
