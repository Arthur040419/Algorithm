package baidu;

import java.util.Scanner;

//k-权值
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long K = sc.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long max = arr[i];
            long min = arr[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                long diff = max - min;
                if (K >= (j - i + 1) * diff) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}
