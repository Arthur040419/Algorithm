package csp_36;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n+1];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length-1; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int tmp=b[i];
            b[i]=0;
            System.out.print(ifIBad(a, b, n)+" ");
            b[i]=tmp;
        }

    }

    public static int ifIBad(int[] a,int[] b,int n){
        //动态规划,dp[i]代表到第i个节点时的最少能量
        int[] dp = new int[n+1];
        //energy[i]表示到第i个节点时拥有的能量值
        int[] energy = new int[n+1];

        //初始化动态数组
        dp[0]=a[0];
        energy[0]=b[0];

        //遍历动态数组
        for (int i = 1; i < n+1; i++) {
            if(energy[i-1]>=a[i]){
                dp[i]=dp[i-1];
                energy[i]=energy[i-1]-a[i]+b[i];
            }else if(energy[i-1]<a[i]){
                dp[i]=dp[i-1]+a[i]-energy[i-1];
                energy[i]=b[i];
            }
        }

        return dp[n];
    }

}
