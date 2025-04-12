package algorithm;

import java.util.Arrays;

//有序数组的平方
public class LeetCode977 {
    public static void main(String[] args) {
        int[] arr = sortedSquares(new int[]{-1, 2, 2});
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortedSquares(int[] nums) {
        //相向双指针
        int left = 0;
        int right = nums.length - 1;
        int[] newArr = new int[nums.length];
        //逆向放入新数组，因为平方后最大值一定在最两边
        for (int i = newArr.length - 1; i >= 0; i--) {
            if((nums[left]*nums[left])>(nums[right]*nums[right])){
                newArr[i]=nums[left]*nums[left];
                left++;
            }else{
                newArr[i]=nums[right]*nums[right];
                right--;
            }
        }
        return newArr;
    }

    public static int[] sortedSquares_My(int[] nums) {
        int[] newArr = new int[nums.length];
        //非负数的索引，从左向右
        int left = 0;
        //负数的索引，从右向左
        int right = 0;
        while (nums[left] < 0 && left < nums.length) left++;       //找到第一个非负数
        if (left == 0) {
            //说明没有负数
            for (int i = 0; i < nums.length; i++) {
                newArr[i] = nums[i] * nums[i];
            }
        }
        if (left >= nums.length) {
            //说明没有正数
            for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
                //没有负数就直接按逆序存
                newArr[j] = nums[i] * nums[i];
            }
        } else {
            //如果有负数
            right = left;
            left -= 1;
            int index = 0;
            while (left >= 0 || right < nums.length) {
                if (left >= 0 && right < nums.length) {
                    if ((-1) * nums[left] > nums[right]) {
                        newArr[index] = nums[right] * nums[right];
                        right++;
                        index++;
                    } else {
                        newArr[index] = nums[left] * nums[left];
                        left--;
                        index++;
                    }
                } else if (left < 0 && right < nums.length) {
                    //左半部分已经没了，直接将右半部分遍历完
                    while (right < nums.length) {
                        newArr[index] = nums[right] * nums[right];
                        index++;
                        right++;
                    }
                } else if (left >= 0 && right >= nums.length) {
                    //右半部分没了，直接将左半部分遍历完
                    newArr[index] = nums[left] * nums[left];
                    index++;
                    left--;
                }

            }
        }
        return newArr;

    }
}
