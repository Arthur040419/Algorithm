package xiaohongshu2025;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] bits = new int[n];        //每个数字对应的位数
        int biggestBit = 0;             //最大的位数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            String numString = input[i] + "";
            bits[i] = numString.length();
            biggestBit = Math.max(biggestBit, bits[i]);
            sb.append(numString);
        }
        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);
        int charIndex = charArray.length - 1;      //字符数组开始的位置，从大到小
        //贪心策略，位数高的优先选大的数字
        int ans = 0;
        //从最高位开始遍历
        for (int i = biggestBit; i > 0; i--) {
            for (int j = 0; j < bits.length; j++) {
                if (bits[j] == i) {
                    int addNum = (charArray[charIndex] - '0') * (int) Math.pow(10.0, i - 1);
                    ans+=addNum;
                    bits[j]-=1;
                    charIndex-=1;
                }
            }
        }
        System.out.println(ans);
    }
}
