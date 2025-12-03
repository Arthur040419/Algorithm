package algorithm;

import java.util.Scanner;

//KamaCoder56.携带矿石资源
public class KamaCoder56 {

    public static void main(String[] args) {
        /**
         * 思路：多重背包问题
         * 多重背包与01背包的区别在于，01背包的物品只有一个，而多重背包的物品可能有多个
         * 所以多重背包也可以看成是01背包问题，只需要将数量为n(n>1)的物品，看成n个不同的物品即可，只不过这物品的价值和重量都是相同的
         *
         */

        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        int[] dp = new int[c + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < num[i]; j++) {
                for (int k = c; k >= weight[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[c]);
    }
}
