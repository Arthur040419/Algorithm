package sort;

import java.util.Arrays;

//排序算法：归并排序
public class MergeSort {


    public static int[] mergeSort(int[] num, int start, int end) {
        /**
         * 思路：
         * 归并排序是基于分治的排序算法。
         * 下面基于例子来讲解思路，排序：1、4、6、2、3、5、8、7
         * 首先是分：将数组均分成两部分，一直分，直到数组最终只剩下一个元素
         * 此时，数组依次被分为了8组，顺序是1、4、6、2、3、5、8、7
         *
         * 然后就是合并：
         * 合并就是两两合并，排序就是发生在合并的时候
         * 合并1、4，结果为：1、4
         * 合并6、2，结果为：2，6
         * 合并3、5，结果为：3、5
         * 合并8、7，结果为：7、8
         *
         * 接着两两合并：
         * 合并1、4和2、6，结果为：1、2、4、6 这里合并原理实际上是双指针，两个指针分别指向两个数组，哪个小就先放哪个
         * 合并3、5和7、8，结果为：3、5、7、8
         *
         * 最后合并剩下的两个数组：
         * 合并1、2、4、6和3、5、7、8，结果为：1、2、3、4、5、6、7、8
         */

        //如果数组只剩下一个元素，直接返回
        if (start == end) {
            return new int[]{num[start]};
        }

        //分，将数组分成两份
        int mid =  (end + start) / 2;
        //递归排序分割后的两组数组
        int[] num1 = mergeSort(num, start, mid);
        int[] num2 = mergeSort(num, mid + 1, end);
        //切割后的两个数组排序好后就再将它们合并
        int i = 0;
        int j = 0;
        int[] sortNum = new int[end - start + 1];
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                sortNum[i + j] = num1[i++];
            } else {
                sortNum[i + j] = num2[j++];
            }
        }

        while (i < num1.length) {
            sortNum[i + j] = num1[i++];
        }


        while (j < num2.length) {
            sortNum[i + j] = num2[j++];
        }

        return sortNum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 2, 3, 5, 8, 7};
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
    }

}
