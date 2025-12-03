package baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//满减活动
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long x = sc.nextLong();
        long res = x;

        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a <= x) {
                res = Math.min(res, x - b);
            }
        }
        System.out.println(res);
    }

}
