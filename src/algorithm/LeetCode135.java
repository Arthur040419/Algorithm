package algorithm;

//135.分发糖果
public class LeetCode135 {

    public int candy(int[] ratings) {
        /**
         * 2025-09-22 字节二面第二道算法，寄
         * 思路：贪心
         * 首先考虑右边大于左边的情况，从左往右遍历rating，得到一个糖果数组
         * 然后考虑左边大于右边的情况，从右往左遍历rating，也能得到一个糖果数组
         * 然后同一个位置下，两个糖果数组中较大的值就是该位置的最终值
         */

        //从左往右遍历
        int[] arr1 = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                arr1[i] = arr1[i - 1] + 1;
            } else {
                arr1[i] = 1;
            }
        }

        //从右往左遍历
        int[] arr2 = new int[ratings.length];
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                arr2[i] = arr2[i+1]+1;
            }else {
                arr2[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            ans+=Math.max(arr1[i],arr2[i]);
        }
        return ans;
    }

}
