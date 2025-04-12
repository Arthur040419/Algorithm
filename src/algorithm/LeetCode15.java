package algorithm;

import java.util.*;

//15.三数之和
public class LeetCode15 {

    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
    }



    public static List<List<Integer>> threeSum(int[] nums){
        //参考别人写的代码
        List<List<Integer>> result = new ArrayList<>();
        //数组排序
        Arrays.sort(nums);
        //如果排序后的第一个元素就大于0，那么不可能存在元组和为0的情况
        if(nums[0]>0){
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            //去除重复情况
            //去重逻辑需要学习一下，如果元组的第一个数相等，在寻找元组后面两个数时由于寻找范围就是在nums这个数组中，因此符合题意的元组肯定也是一样的
            //因此只要第一个元素重复了，就说明元组也会重复
            //而这里是判断nums[i]==nums[i--]而不是nums[i]==nums[i++]
            //这是因为如果是后面的判断方式，会导致元组内部中不能出现重复元素，但是元组内出现重复元素是允许的，比如元组：-1,-1,2
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    //如果当前和的元组和大于0，就左移right指针，尝试减小当前元组和
                    right--;
                }else if (sum<0){
                    //如果当前和的元组和小于0，就右移left指针，尝试增大当前元组和
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //对元组的后面两个数字去重，让当前找到的元组只会出现一次
                    while(left<right && nums[right]==nums[right-1]) right--;
                    while(left<right && nums[left]==nums[left+1]) left++;

                    //接着寻找新的元组
                    right--;
                    left++;
                }

            }

        }

        return result;
    }


    public static List<List<Integer>> threeSum_My(int[] nums) {
        //自己写的代码
        /**
         * 思路：双指针法
         * 首先将数组排序
         * 定义一个left和right指针
         * 接下来遍历数组，i表示索引，最开始时，i指向索引0，left指向索引i+1的元素，right指向最后一个元素
         * 计算两个指针和当前遍历到的元素nums[i]的和
         * 如果这个和小于0，就移动left，尝试让和变大；如果这个和大于0，就移动right，尝试让这个和变小
         * 直到这个和变为0或者left和right指针相遇，和变为0就记录这个元组
         * 接着让i索引加1，遍历下一个元素，left依然指向索引为i+1的元素，right依然指向最后一个元素
         * 再按照上面的步骤找到和为0的元组
         * 一直遍历，直到遍历完所有元素，即i指向数组倒数第三个元素时。
         */

        //返回结果
        Set<List<Integer>> result = new HashSet<>();

        //数组排序
        Arrays.sort(nums);
        //定义指针
        int left;
        int right;
        //遍历数组
        for (int i = 0; i < nums.length-2; i++) {
            left = i + 1;
            right=nums.length-1;
            int sum = nums[i] + nums[left] + nums[right];
            while (left < right) {
                if (sum>0){
                    //如果元组和大于0，就左移right指针，尝试减小这个和
                    right--;
                }else if(sum<0){
                    //如果元组和小于0，就右移left指针，尝试增大这个和
                    left++;
                }else{
                    //记录元组
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
                sum=nums[i]+nums[left]+nums[right];
            }
        }
        return result.stream().toList();
    }
}
