package boleGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//优质数组
public class Main3 {


    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.min_operation(7, new int[]{2, 4, 2}));
    }

    public int min_operation(int m, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int value = sum % m;

        /**
         * value 是数组总和对m取余的结果
         * 两种策略
         * 1.直接让任意元素+1
         * 2.尝试删除某个元素，尝试在数组中找到能组合成value的组合，并删除，如果这个组合的元素个数大于m-value，就取第一种策略
         *   如果找不到组合，就删除一个与value最接近的元素delete，并执行策略1 |delete-value|次
         */

        int res = Integer.MAX_VALUE;

        //策略1
        res = Math.min(res, m - value);

        //策略2
        //寻找组合-数组排序后，保证组合的长度最小
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> arr = findArr(nums, visited, value);
        if (arr != null && !arr.isEmpty() && arr.size() != nums.length) {
            res = Math.min(res, arr.size());
        }

        //尝试删除与value最接近的值
        int tmp = value;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp <= 0) {
                break;
            }
            tmp -= nums[i];
            count++;
        }
//        if (tmp >= 0) {
//            //直接全删除
//            res = Math.min(res, nums.length);
//        } else {
//            res = Math.min(res, Math.abs(tmp) + count);
//        }

        if (tmp < 0) {
            res = Math.min(res, Math.abs(tmp) + count);
        }

        return res;

    }

    public List<Integer> findArr(int[] nums, boolean[] visited, int value) {
        if (value == 0) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            if (value - nums[i] < 0 || visited[i]) {
                continue;
            }
            List<Integer> arr = findArr(nums, visited, value - nums[i]);
            if (arr != null) {
                arr.add(nums[i]);
                visited[i] = true;
                return arr;
            }
        }

        return null;

    }

}
