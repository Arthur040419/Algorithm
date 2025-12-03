package jinshan2;


import java.util.Arrays;
import java.util.Scanner;

//两个有序数组间相加和的topK问题
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] arr = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(arr);
        for (int i = index - 1; i > index - k - 1; i--) {
            System.out.print(arr[i]+" ");
        }
    }

}
