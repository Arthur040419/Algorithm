package algorithm;


import java.util.HashMap;
import java.util.Map;

//四数相加
public class LeetCode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*思路：
         * 如果存在满足要求的元组，那么元组中前两个数，即nums1和nums2中的数的和一定和后两个数，即nums3和nums4中的数的和是互为相反数的
         * 也就是说我们可以先统计前两个数组的所有可能的相加结果，用一个map集合存储，key为相加结果，value为该相加结果出现的次数
         * 接着我们遍历后面两个数组，如果它们中的两个数相加的结果的相反数刚好在map集合中出现过，就说明找到了合适的元组，取出该相反数对应的值加到最终的统计结果中
         */


        //map集合，用于存储前两个数组遍历的结果
        Map<Integer,Integer> map = new HashMap<>();
        //count用于统计满足要求的元组个数
        int count=0;

        //遍历前两个数组
        for (int num1 : nums1) {
            for (int num2 : nums2) {
               Integer key = num1+num2;
               map.put(key,map.getOrDefault(key,0)+1);
            }
        }

        //遍历后面两个数组
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                Integer key = 0-num3-num4;
                count+=map.getOrDefault(key,0);
            }
        }
        return count;
    }
}
