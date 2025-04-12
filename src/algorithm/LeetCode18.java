package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//四数之和
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 思路：
         * 将四数之和分解为一个数和三个数之和
         * 即：如果四数之和目标值为target，那么我们从nums中任意取出一个值nums[i]
         * 然后再去找剩下三个值，剩下三个值的目标值就是target-nums[i]
         * 然后再用之前写三数之和的方法去找那三个数
         */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //剪枝
        if(target<nums[0]&&nums[0]>0){
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            //取出第一个数
            //去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            //寻找剩下三个数
            for (int j = i+1; j < nums.length; j++) {
                //去重
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target){
                        //如果元组和大于目标值，就左移right指针，尝试减小元组的和
                        right--;
                    }else if(sum<target){
                        //如果元组和小于目标值，就右移left指针，尝试增大元组的和
                        left++;
                    }else{
                        //如果元组和等于目标值，记录元组
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        while(left<right&&nums[right]==nums[right-1]) right--;
                        while(left<right&&nums[left]==nums[left+1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

}
