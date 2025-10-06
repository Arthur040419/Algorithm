package pdd20250928;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (!isValid(input)) {
            System.out.println("Invalid");
            return;
        } else {
            char check = getCheckChar(input);
            if (input.charAt(input.length() - 1) != check) {
                String res = input.substring(0,input.length()-1);
                System.out.println(res + check);
                return;
            }else {
                System.out.println(input);
            }
        }
    }

    public static boolean isValid(String input) {
        int len = input.length();
        if (len < 9) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char curChar = input.charAt(i);
            if (i < 2) {
                if ('A' > curChar || curChar > 'Z') {
                    return false;
                }
            } else if (i < len - 1) {
                if ('0' > curChar || curChar > '9') {
                    return false;
                }
            } else {
                if ('A' > curChar || curChar > 'Z') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getCheckChar(String input) {
        int len = input.length();
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += input.charAt(i);
        }
        sum %= 26;
        sum += 'A';
        return (char) sum;
    }

}
