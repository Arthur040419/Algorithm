import java.util.HashMap;
import java.util.Map;

public class Main1113 {

    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，
         * 判断是否存在三元组 [nums[i], nums[j], nums[k]]
         * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
         * 请你返回所有和为 0 且不重复的三元组。
         */

        // 0、2、5    1、2、4
        int[] arr = {-3, -2, 0, 1, 2, 3};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int add = -(arr[i] + arr[j]);
                if (map.containsKey(add) && map.get(add) != i && map.get(add) != j) {
                    System.out.println(i + " " + j + " " + map.get(-(arr[i] + arr[j])));
                }
            }
        }
    }

}
