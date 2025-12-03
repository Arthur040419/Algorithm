package boleGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//数组排序-排序后使相邻元素和为奇数，返回字典序最小的结果
public class Main1 {

    public int[] rearrange_odd_even(int[] nums) {
        // write code here

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        if (odd.isEmpty() || Math.abs(odd.size() - even.size()) > 1) {
            return new int[]{-1};
        }

        List<Integer> first = null;
        List<Integer> second = null;
        //确定先后顺序
        if (odd.size() == even.size()) {
            if (odd.get(0) < even.get(0)) {
                first = odd;
                second = even;
            } else {
                first = even;
                second = odd;
            }
        } else if (odd.size() > even.size()) {
            first = odd;
            second = even;
        } else {
            first = even;
            second = odd;
        }

        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = first.get(firstIndex++);
            if (i + 1 < nums.length) {
                nums[i + 1] = second.get(secondIndex++);
            }
        }

        return nums;
    }

}
