package qiniu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//2025七牛笔试第一题
public class Main1 {
    public static void main(String[] args) {
        RightSideView(new int[]{1,2,3,4,5,6,7});
    }

    public static int[] RightSideView (int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        list.add(nums[index]);
        index = (int)Math.pow(2,index)+1;
        while (index<nums.length){
            list.add(nums[index]);
            index = (int)Math.pow(2,index)+2;
        }

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();

        return array;
    }
}
