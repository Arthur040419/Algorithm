package algorithm;


import java.util.Scanner;

//爬楼梯
public class KamaCoder57 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //dp[i]表示爬到第i阶的方法数
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }

            }
        }

        System.out.println(dp[n]);
    }

}
