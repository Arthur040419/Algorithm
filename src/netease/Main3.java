package netease;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        //dp[i][j]表示第i到j天如果用来倒卖，每天的收益是多少，如果是负收益，直接用-1表示
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = price[j] - price[i] - 2 * k;
                if (profit > m) {
                    dp[i][j] = profit;
                }
            }
        }



        return;
    }

}
