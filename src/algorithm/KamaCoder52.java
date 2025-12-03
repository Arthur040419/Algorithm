package algorithm;

import java.util.Scanner;

//KamaCoder52.携带研究材料（完全背包问题）
public class KamaCoder52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        //1.定义dp数组,dp[i][j]表示将前i个物品放入容量为j的背包能获得的最大价值
        int[][] dp = new int[n][v + 1];

        /**
         *2.确定状态转移方程，对于第i件物品，可以选择放与不放
         *  如果选择不放，那么dp[i][j] = dp[i-1][j]
         *  如果选择放，那么dp[i][j] = dp[i][j-weight[i]]+value[i]
         *  这里与01背包的不同点就在于，每一个物品都可以无限放入，所以当选择放入物品时，很可能是多次放入，所以是dp[i][j-weight[i]]+value[i]而不是dp[i-1][j-weight[i]]+value[i]
         */

        //3.初始化dp数组，由状态转移方程可以知道，dp[i][j]是有上方和左方推导而来，所以需要初始化dp[i][0]和dp[0][i],遍历顺序也是从左到右

        //注意这里初始化的代码，不能用
//        for (int i = 0; i < v + 1; i++) {
//            dp[0][i] = i * value[0] / weight[0];
//        }
        for (int i = weight[0]; i < v + 1; i++) {
            dp[0][i] = dp[0][i - weight[0]] + value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 1][v]);
        sc.close();
    }
}
