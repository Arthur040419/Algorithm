package xiaohongshu2025;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        while (sb.indexOf("0") != -1 && sb.indexOf("1") != -1) {
            for (int i = sb.length() - 1; i > 0; i--) {
                if(sb.charAt(i)!=sb.charAt(i-1)){
                    ans++;
                    sb.deleteCharAt(i);
                }
            }
        }
        System.out.println(ans);
    }
}

//10 1100010101
