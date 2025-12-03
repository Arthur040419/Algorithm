package zhongguopingan;

import java.util.*;

//中国平安笔试-只有一题算法-最长的斐波那契子序列的长度
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String input = sc.next();
        String[] split = input.split(",");
        for (int i = 0; i < split.length; i++) {
            int num = Integer.valueOf(split[i]);
            arr.add(num);
            map.put(num, i);
        }
        //定义dp数组，dp[i][j]表示以下标为i、j的两个数作为作为序列最后两位数时的最长序列长度
        int[][] dp = new int[arr.size()][arr.size()];
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            int numi = arr.get(i);
            int numj = 0;
            if (i - 1 >= 0) {
                numj = arr.get(i - 1);
            }
            for (int j = i - 1; j >= 0 && numj * 2 > numi; j--) {
                int k = map.getOrDefault(numi - numj, -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        System.out.println(ans);
        return;
    }


}
