package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//491.非递减子序列
public class LeetCode491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        /**
         * 思路：
         * 这题实际上也是找子集，但是子集要求是递增的
         * 此外，还需要对子集去重，但是这里去重的方式与之前用的通过used数组的方式不同，因为这里不能对数组进行排序
         * 那么这里的去重逻辑为：
         * 1.用set集合来记录同一层中使用过的数字
         * 2.遍历数组时，如果该元素在set集合中已经出现过了，说明是重复的子集，就跳过该元素
         */

        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int begin) {
        //终止条件，如果path长度大于等于2，就将其添加到结果集中
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> set = new HashSet<>();

        for (int i = begin; i < nums.length; i++) {
            //踩坑点：对于这个用例[1,2,3,4,5,6,7,8,9,10,1,1,1,1,1]，使用下面的代码会出错，因为下面的代码对于第一个元素没有做到去重，只要是第一个元素都会直接进入path中，所以导致重复出现了以1开头子集。
//          if(path.isEmpty()||(nums[i]>=path.get(path.size()-1)&&!set.contains(nums[i]))){
            if ((path.isEmpty() || nums[i] >= path.get(path.size() - 1)) && !set.contains(nums[i])) {
                path.add(nums[i]);
                set.add(nums[i]);
                backtracking(nums, i + 1);
                //回溯
                path.remove(path.size() - 1);
            }
        }

    }
}
