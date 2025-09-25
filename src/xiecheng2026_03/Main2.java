package xiecheng2026_03;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();
        char[] charArray = line.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if (isLower(c)) {
                if (c == 'a') {
                    c = 'z';
                } else {
                    c -= 1;
                }
            } else {
                if (c == 'Z') {
                    c = 'A';
                } else {
                    c += 1;
                }
            }
            charArray[i] = c;
        }

        boolean[] isDeleted = new boolean[charArray.length];
        int font = n - 2;
        int back = n - 1;
        for (; font >= 0; font--) {
            char fontChar = charArray[font];
            char backChar = charArray[back];
            if (isLower(fontChar) && fontChar - 'a' == backChar - 'A') {
                isDeleted[font] = true;
            } else if (!isLower(fontChar) && fontChar - 'A' == backChar - 'a') {
                isDeleted[font] = true;
            } else {
                back = font;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(!isDeleted[i]){
                sb.append(charArray[i]);
            }
        }
        System.out.println(sb);
    }

    public static boolean isLower(char c) {
        if ('a' <= c && c <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean isUpper(char c) {
        if ('A' <= c && c <= 'Z') {
            return true;
        }
        return false;
    }
}
