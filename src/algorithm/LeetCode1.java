package algorithm;

import java.util.HashMap;
import java.util.Map;

//两数之和
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        /*思路：
         * 使用一个Map集合来记录已经访问过的数组元素，Map集合的Key代表数组元素，Value代表元素下标
         * 每遍历一个数组元素，就到Map集合中去寻找有没有合适的元素，即：找有没有元素与当前遍历的元素相加结果为target
         * 如：当前遍历数组元素值为2，目标值为9，那就去Map集合中找有没有7这个元素
         *
         * */

        Map<Integer, Integer> record = new HashMap<>();
        int[] result = new int[2];
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (record.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = record.get(target - nums[i]);
                return result;
            }
            record.put(nums[i], i);
        }
        return result;
    }

    //复习
    public int[] twoSum_Review(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }else {
                map.put(nums[i],i);
            }

        }
        return result;
    }

    //复习2
    public int[] twoSum_Review2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return  result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
