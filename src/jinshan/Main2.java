package jinshan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0;
        for (int i = 0; i < t; i++) {
            x = sc.nextInt();
            System.out.println(getRes(x));
        }
    }

    public static int getRes(int x) {
        int q = (int) Math.sqrt(x);
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= q; i++) {
            if (x % i == 0) {
                //不继续分解
                max = Math.max(getCount(i) + getCount(x / i), max);
                //全部继续分解
                max = Math.max(getRes(i) + getRes(x / i), max);
                //左边继续分解
                max = Math.max(getRes(i) + getCount(x / i), max);
                //右边继续分解
                max = Math.max(getCount(i) + getRes(x / i), max);
            }
        }
        if (max == Integer.MIN_VALUE) {
            max = 2;
        }
        return max;
    }

    //获取因子个数
    public static int getCount(int x) {
        int count = 2;
        int q = (int) Math.sqrt(x);
        for (int i = 2; i <= q; i++) {
            if (x % i == 0) {
                count += 2;
            }
        }
        return count;
    }

}
