package shunfeng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int arrayLen = 0;
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            arrayLen += b[i];
        }
        int[] newArray = new int[arrayLen];
        int[] prefix = new int[arrayLen];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b[i]; j++) {
                newArray[index] = a[i];
                if (index > 0) {
                    prefix[index] = prefix[index - 1] + newArray[index];
                } else {
                    prefix[index] = newArray[index];
                }
                index++;
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(prefix[r-1] - prefix[l-1] + newArray[l-1]);
        }
    }


}
