package jitu;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (k + 1 == n) {
            for (int i = n; i > 0; i--) {
                System.out.print(i + " ");
            }
            return;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }

        int left = 0;
        int right = n - 1;
        int tmp = 0;
        while (k >= 2) {
            tmp = res[left];
            res[left] = res[right];
            res[right] = tmp;
            left++;
            right--;
            k -= 2;
        }
        if (k == 1) {
            tmp = res[right - 1];
            res[right - 1] = res[right];
            res[right] = tmp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
