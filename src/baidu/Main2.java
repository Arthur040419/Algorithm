package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//小权值
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Math.ceil(5.0));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] tmpK = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tmpK[i][j] = (int) Math.ceil(Math.abs(arr[i] - arr[j]) / (Math.abs(i - j) * 1.0));
            }
        }

        int res = 0;
        int[][] possbileK = new int[n][n];
        for (int len = 2; len < n + 1; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (len > 2) {
                    possbileK[i][i + len - 1] = Math.max(Math.max(tmpK[i + 1][i + len - 1], tmpK[i][i + len - 2]), tmpK[i][i + len - 1]);
                } else {
                    possbileK[i][i + len - 1] = tmpK[i][i + len - 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res += possbileK[i][j];
            }
        }

        System.out.println(res);
    }

}
