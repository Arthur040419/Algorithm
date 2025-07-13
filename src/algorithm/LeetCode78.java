package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//78.子集
public class LeetCode78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int begin) {
        //终止条件按理来说是当begin大于数组的长度时就该终止，但是当begin大于数组长度时循环也不会执行，因此这里终止条件可以不写
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            //回溯
            path.remove(path.size()-1);
        }
        result.add(new ArrayList<>(path));
        //踩坑点：保存集合时要注意重新创建一个集合
//        result.add(path);

    }
}
