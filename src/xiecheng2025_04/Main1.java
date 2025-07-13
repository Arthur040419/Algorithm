package xiecheng2025_04;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int man = 0;
        int woman = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='M') man++;
            else woman++;
            if(man>woman) count++;
        }
        System.out.println(count);
    }
}
