package algorithm;

import java.util.*;

//560.和为k的子数组
public class LeetCode560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        /**
         * 思路1(自己想的，用例：54/93)：前缀和
         * 用一个set集合记录所有的前缀和，然后统计两种情况出现的次数：
         * 1.前缀和的结果就是k
         * 2.某一个前缀和+k在集合中存在，也就是说存在前缀和B-前缀和A等于k，也就说明存在连续子数组之和等于k
         *  这个思路在数字全是非负数的情况下可能是正确的
         *
         * 思路2（LeetCode官方题解）：前缀和+map集合优化
         * 从左到右遍历数组，并记录前缀和，用map集合存储某一个和的值出现的次数
         * 如果存在一个连续的数组的和等于k，那么一定有下面的关系：
         * pre[i]+k = pre[j]    i<j
         * 转换一下就是pre[i]=pre[j]-k
         * 在遍历的过程中就可以统计pre[j]-k出现的次数，将其加到结果中，最后遍历完的结果就是最终答案
         */

        int result = 0;
        //统计前缀和
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result+=map.getOrDefault(sum-k,0);      //这一行和下面一行的代码执行顺序不能反过来，反过来会导致k=0时，错误地算上自己减自己，也就是子数组长度为0的情况。
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return result;
    }

    //复习
    public static int subarraySum_Review(int[] nums, int k) {
        int curPre = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();     //存储同一个前缀和出现的次数
        map.put(0,1);       //这个很重要
        for (int i = 0; i < nums.length; i++) {
            curPre += nums[i];
            ans += map.getOrDefault(curPre-k,0);
            map.put(curPre,map.getOrDefault(curPre,0)+1);
        }
        return ans;
    }

}
