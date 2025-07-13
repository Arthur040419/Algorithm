package algorithm;

import javax.print.DocFlavor;
import java.util.Arrays;

//455.分发饼干
public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        /**
         * 思路：采用贪心策略
         * 尽可能使用最小的饼干满足某一个孩子
         */
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0;
        int indexS = 0;

        int count = 0;

        while (indexG < g.length && indexS < s.length) {
            if(s[indexS]>=g[indexG]){
                count++;
                indexG++;
                indexS++;
            }else {
                indexS++;
            }
        }
        return count;
    }
}
