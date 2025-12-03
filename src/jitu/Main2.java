package jitu;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b < a - 1) {
            System.out.println("-1");
            return;
        }

        for (int i = 0; i < a; i++) {
            if (b > 0) {
                System.out.print("1 " + "2 ");
            } else {
                System.out.println("1 ");
            }
            b--;
        }
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                System.out.println("2 ");
            }
        }
    }

}
