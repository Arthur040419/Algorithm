package yongyou2025_2;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][3];
        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            input[i][0] = sc.nextInt();
            begin = Math.min(begin,input[i][0]);
            input[i][1] = sc.nextInt();
            end = Math.max(end,input[i][1]);
            input[i][2] = sc.nextInt();
        }

        int ans = 0;
        for (int i = begin; i <= end ; i++) {
            int tmp = 0;
            for (int[] ints : input) {
                if(ints[0]<=i&&i<=ints[1]){
                    tmp+=ints[2];
                }
            }
            ans = Math.max(ans,tmp);
        }

        System.out.println(ans);
    }
}
