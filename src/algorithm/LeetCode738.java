package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//738.单调递增的数字
public class LeetCode738 {
    public int monotoneIncreasingDigits(int n) {
        /**
         * 思路：
         * 对于一个数字，如果它是单增的，直接返回即可
         * 如果它不是单增的，中间出现了递减的情况，也就是 number[i-1]>number[i]的情况，就可以将第i-1个数字减1然后将第i个数字设置为9
         * 这样一来，获取的就是最大的、且每位数字是递增的结果
         * 从后往前遍历，因为如果从前往后遍历就可能导致后面的数字又小于前面的数字了，比如332，从前往后遍历时就会变成329，导致第二个数字小于第1个数字了
         */

        //将数字转换成数组
        String s = n + "";
        char[] charArray = s.toCharArray();
        //要变成9的数字起点
        int start = charArray.length;

        //从后往前遍历
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] > charArray[i + 1]) {
                charArray[i]--;
                //这里不能直接赋值为9，因为对于100这种情况最后一个0无法被赋为9，最终结果会是90而不是99
//                charArray[i+1] = '9';
                //记录要变成9的起点，后面统一赋值为9
                start = i + 1;
            }
        }
        //统一给后面的数字赋值为9
        for (int i = start; i < charArray.length; i++) {
            charArray[i] = '9';
        }


        String result = new String(charArray);
        return Integer.parseInt(result);

    }
}
