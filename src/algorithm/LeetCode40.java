package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40.组合总和II
public class LeetCode40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //used[i]表示第i个数是否已经被使用过
        boolean[] used = new boolean[candidates.length];
        //对数组进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, used, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, boolean[] used, int begin, int sum) {
        /**
         * 思路：
         * 这里主要是要讲一下如何去除重复的组合
         * 对于同一层的取值，如果当前取值在前面已经使用过了，就认为这是一个重复的组合
         * 比如这个已经排好序的数组：[1,1,3]
         * 此时处理第一层的时候，首先取的值就是第一个1，接着就会取第二个1，而这个第二个1就认为是重复的组合
         * 要想在代码中来进行上面说的重复判断，就要借助used数组：
         * 当candidates[i]==candidates[i-1]并且used[i-1]==false，就说明当前取值与前面的产生了重复，used[i-1]==false说明的是这第i-1个数是回溯过来的
         * 当candidates[i]==candidates[i-1]并且used[i-1]==true，就说明没有产生重复
         */

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        //剪枝优化，如果sum+当前值已经大于目标值，就直接停止循环
        for (int i = begin; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, used, i + 1, sum + candidates[i]);
            //回溯
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }
}
