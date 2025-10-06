package xiaohongshu2025;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prefix = new int[n];      //前缀和
        //int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            prefix[i] = num;
            //numbers[i] = num;
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        int ans = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i > 0) {
                    tmp = prefix[j] - prefix[i - 1];
                } else {
                    tmp = prefix[j];
                }
                if (tmp == k) {
                    ans += n - j;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

//5、4
//-7 9 2 -8 5
