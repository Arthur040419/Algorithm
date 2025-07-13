package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39.组合总和
public class LeetCode39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //踩坑点1：没有将数组排序，如果不排序，后面的剪枝优化就没有用。
        //把数组排序一下
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int begin, int sum) {
        //终止条件，当总和大于等于目标值时
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum>target) return;

        for (int i = begin; i < candidates.length; i++) {
            //剪枝优化：如果sum+当前遍历的值已经大于target时，说明后续的遍历都会大于target，就没有必要遍历下去了
            if(sum+candidates[i]>target) break;
            path.add(candidates[i]);
            backtracking(candidates,target,i,sum+candidates[i]);
            //回溯
            path.remove(path.size()-1);
        }
    }
}
