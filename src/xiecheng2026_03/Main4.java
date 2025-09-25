package xiecheng2026_03;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        //System.out.println(count(array, 0, 4));

        int[][] before = new int[n][n];     //区间反转前的逆序对个数
        int[][] after = new int[n][n];      //区间反转后的逆序对个数
        int diffMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                before[i][j] = count(array, i, j);
                after[i][j] = countReverse(array, i, j);
                diffMax = Math.max(before[i][j] - after[i][j], diffMax);
            }
        }
        System.out.println(before[0][n - 1] - diffMax);
    }

    public static int count(int[] array, int start, int end) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (array[i] > array[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int countReverse(int[] array, int start, int end) {
        int cnt = 0;
        for (int i = end; i >= start; i--) {
            for (int j = i - 1; j >= start; j--) {
                if (array[i] > array[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
