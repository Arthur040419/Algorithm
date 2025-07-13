package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

//1005.k次取反后最大化的数组和
public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        /**
         * 思路：贪心
         * 如果希望数组和最大，只需要尽可能将所有数变成正数
         * 如果k大于负数个数，就可以保证所有负数都能够变成正数，然后只需要把剩下的变换次数全部给到绝对值最小的那个数即可
         * 如果k小于负数个数，就优先将绝对值最大的负数变成正数，最大限对提高数组和的大小
         */

        //对原数组按照绝对值大小排序，这个数组排序方法要掌握
        nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();

        //从前往后遍历数组，如果遇到负数，就将其变为正数，如果遇到正数，就跳过
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
                if(k==0) break;
            }
        }
//        while (k>0){
//            nums[nums.length-1] = -nums[nums.length-1];
//            k--;
//        }
        //优化上面的代码
        if(k%2==1) nums[nums.length-1] = -nums[nums.length-1];

//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            result+=nums[i];
//        }
//        return result;

        //优化上面的代码
        return Arrays.stream(nums).sum();

    }
}
