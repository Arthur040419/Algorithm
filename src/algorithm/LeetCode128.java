package algorithm;

import java.util.HashSet;
import java.util.Set;

//128.最长连续序列
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        /**
         * 思路：
         * 题目要求要O(n)的时间复杂度，那么排序自然就不行了，排序的最小时间复杂度为O(nlogn)
         * 这题可以用哈希，可以使用HashSet来存储数组中的每一个元素
         * 然后遍历哈希集合，对于每一个元素x，去判断x+1、x+2、x+3是否存在于哈希集合中，存在就更新数字连续序列的长度
         * 这里一个比较关键的点在于，对于一个元素x应该先判断x-1是否存在于集合中，如果存在，就跳过x，因为到时候遍历到x-1时就可以直接得出答案
         */

        //将数组元素存入HashSet集合中
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //最长序列
        int maxLen = 0;
        //当前序列长度
        int curLen = 0;
        for (Integer x : set) {
            //判断x-1是否存在于集合中
            if (set.contains(x - 1)) {
                continue;
            }
            while (set.contains(x + curLen)) {
                curLen++;
            }
            maxLen = Math.max(maxLen,curLen);
            curLen=0;
        }

        return maxLen;
    }

    //复习
    public int longestConsecutive_Review(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (Integer num : set) {
            if(set.contains(num-1)){
                //当前num不是起点
                continue;
            }
            int curLen = 0;
            while (set.contains(num+curLen)){
                curLen++;
            }
            ans = Math.max(ans,curLen);
        }
        return ans;
    }
}
