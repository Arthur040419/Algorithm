package xiaotiancai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        int num1Min = (int) Math.pow(10, a - 1);
        int num2Min = (int) Math.pow(10, b - 1);
        int num1Max = (int) Math.pow(10, a) - 1;
        int num2Max = (int) Math.pow(10, b) - 1;
        int num3Min = (int) Math.pow(10, c - 1);
        int num3Max = (int) Math.pow(10, c) - 1;


        if (num1Max * num2Max < num3Min || num1Min * num2Min > num3Max) {
            System.out.println("-1");
            return;
        }

        int num1 = num1Max;
        int num2 = num2Max;

        int i = 1;
        while (true) {
            int result = num1 * num2;
            if (result > num3Max) {
                double q = (result * 1.0 - num3Max * 1.0) / result;
                if (i % 2 == 0) {
                    num1 *= (1 - q / 2.0);
                } else {
                    num2 *= (1 - q / 2.0);
                }
                i++;
            } else if (result < num3Min) {
                double q = (num3Min * 1.0 - result * 1.0) / result;
                if (i % 2 == 0) {
                    num1 *= (1 + q / 2.0);
                } else {
                    num2 *= (1 + q / 2.0);

                }
                i++;

            } else {
                System.out.println(num1 + " " + num2);
                return;
            }

        }

    }

}
