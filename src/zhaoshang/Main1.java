package zhaoshang;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prices = sc.next();
        String[] split = prices.split(",");
        double[] array = Arrays.stream(split).mapToDouble(value -> Double.valueOf(value)).toArray();
        double maxProfit = 0;
        double minPrice = array[0];
        double ans = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                ans += array[i - 1] - minPrice;
                minPrice = array[i];
            }
        }
        ans += array[array.length - 1] - minPrice;
        System.out.println(ans);
    }
}
