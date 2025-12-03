package oppo;

import java.util.Arrays;
import java.util.Scanner;

//数组分家
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min1 = arr[0];
        int min2 = arr[1];
        int max = 0;
        for (int i = 2; i < n; i++) {
            max += arr[i];
        }

        System.out.println(Math.abs(max - min1) + Math.abs(max - min2));

    }


}
